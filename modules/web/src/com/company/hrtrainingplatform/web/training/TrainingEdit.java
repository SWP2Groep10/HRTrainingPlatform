package com.company.hrtrainingplatform.web.training;

import com.company.hrtrainingplatform.entity.*;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.EmailInfo;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.security.entity.User;

import javax.inject.Inject;
import java.util.UUID;

public class TrainingEdit extends AbstractEditor {
    @Inject
    private Table<Location> locationTable;
    @Inject
    protected EmailService emailService;
    @Inject
    private Datasource<Training> trainingDs;
    @Inject
    private UserSessionSource userSessionSource;
    @Inject
    private Table<ISBNnr> recBookListTable;

    public void onSendRequestClick() {
        try {
            Employee userSessionEmp = userSessionSource.getUserSession().getAttribute("employee");
            User curManagerUser = userSessionEmp.getManager().getUser();

            showOptionDialog(
                    "Email",
                    "Send a training request email to your manager -" + curManagerUser.getName() + "- ?",
                    MessageType.CONFIRMATION,
                    new Action[]{
                            new DialogAction(DialogAction.Type.YES) {
                                @Override
                                public void actionPerform(Component component) {
                                    sendByEmail(curManagerUser.getEmail());
                                }
                            },
                            new DialogAction(DialogAction.Type.NO)
                    }
            );
        } catch (NullPointerException e){showNotification("No selection has been made or current user is not an Employee");}
    }

    private void sendByEmail(String requestmail) {

        User curUser= AppBeans.get(UserSessionSource.class).getUserSession().getUser();
        String trainingDesc = trainingDs.getItem().getDescription();
        UUID trainingUUID = trainingDs.getItem().getId();

        EmailInfo emailInfo = new EmailInfo(

                requestmail, // recipients
                "Training Request: "+ trainingDesc, // subject
                null, // the "from" address will be taken from the "cuba.email.fromAddress" app property

                "Training request for: \n"+"Full name: " + curUser.getName()
                        +"\nuser ID: "+ curUser.getLogin() + "\n Training :" + trainingDesc + "\n Training UUID:" + trainingUUID// body template
        );
        emailService.sendEmailAsync(emailInfo);
    }

    public void onShowMapClick() {
        try {
            Location l = locationTable.getSingleSelected();
            Address a = l.getAddress();
            String url = "http://maps.google.com/?q=" + a.getCountry() + "+" + a.getCity() + "+" + a.getPostalcode() + "+" + a.getStreet() + "+" + a.getNumber();
            showWebPage(url, ParamsMap.of("target", "_blank"));
        }
        catch (NullPointerException e){showNotification("No selection has been made.");}
    }

    public void onShowBookClick(Component source) {
        try {
            ISBNnr i = recBookListTable.getSingleSelected();
            String url = "https://books.google.com/books?vid=ISBN" + i.getIsbn();
            showWebPage(url, ParamsMap.of("target", "_blank"));
        }
        catch (NullPointerException e){showNotification("No selection has been made.");}
    }
}
