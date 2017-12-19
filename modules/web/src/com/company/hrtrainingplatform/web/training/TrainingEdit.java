package com.company.hrtrainingplatform.web.training;

import com.company.hrtrainingplatform.entity.*;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.gui.components.AbstractWindow;
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

    public void onSendRequestClick() {

        Employee userSessionEmp = userSessionSource.getUserSession().getAttribute("employee");
        User curManagerUser = userSessionEmp.getManager().getUser();

        showOptionDialog(
                "Email",
                "Send a training request email to your manager -" + curManagerUser.getName() + "- ?",
                MessageType.CONFIRMATION,
                new Action[] {
                        new DialogAction(DialogAction.Type.YES) {
                            @Override
                            public void actionPerform(Component component) {
                                sendByEmail(curManagerUser.getEmail());
                            }
                        },
                        new DialogAction(DialogAction.Type.NO)
                }
        );
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




    public void onShowMapClick(Component source) {

            Location l =locationTable.getSingleSelected();
            Address a = l.getAddress();

                locationTable.setEnabled(true);
                String url = "http://maps.google.com/?q=" + a.getCountry() + "+" + a.getCity() + "+" + a.getPostalcode() + "+" + a.getStreet() + "+" + a.getNumber();
                showWebPage(url, ParamsMap.of("target", "_blank"));

    }
    
    
}