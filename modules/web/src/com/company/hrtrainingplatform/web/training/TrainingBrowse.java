package com.company.hrtrainingplatform.web.training;

import com.company.hrtrainingplatform.entity.*;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.EmailInfo;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.security.entity.User;

import javax.inject.Inject;
import java.util.Date;
import java.util.UUID;

public class TrainingBrowse extends AbstractLookup {

  @Inject
  private Table<Training> trainingsTable;
  @Inject
  protected EmailService emailService;
  @Inject
  private UserSessionSource userSessionSource;

    
    public void onSendRequestClick() {
        try {
            Employee userSessionEmp = userSessionSource.getUserSession().getAttribute("employee");
            User curManagerUser = userSessionEmp.getManager().getUser();
            Training prev = trainingsTable.getSingleSelected();

            showOptionDialog(
                    "Email",
                    "Send a training request email to your manager -" + curManagerUser.getName() + "- ?",
                    MessageType.CONFIRMATION,
                    new Action[]{
                            new DialogAction(DialogAction.Type.YES) {
                                @Override
                                public void actionPerform(Component component) {
                                    sendByEmail(curManagerUser.getEmail());
                                    showNotification("Email has been added to que.");
                                }
                            },
                            new DialogAction(DialogAction.Type.NO)
                    }
            );
        } catch (NullPointerException e){showNotification("No selection has been made or current user is not an Employee");}
    }

    // MAIL FUNCTIONALITY

    private void sendByEmail(String requestmail) {

        User curUser= AppBeans.get(UserSessionSource.class).getUserSession().getUser();

        String trainingDesc = trainingsTable.getSingleSelected().getDescription();
        UUID trainingUUID = trainingsTable.getSingleSelected().getId();

        EmailInfo emailInfo = new EmailInfo(

                requestmail, // recipients
                "Training Request: "+ trainingDesc, // subject
                null, // the "from" address will be taken from the "cuba.email.fromAddress" app property

                "Training request for: \n"+"Full name: " + curUser.getName()
                        +"\nuser ID: "+ curUser.getLogin() + "\n Training :" + trainingDesc + "\n Training UUID:" + trainingUUID// body template
        );
        emailService.sendEmailAsync(emailInfo);
    }
}