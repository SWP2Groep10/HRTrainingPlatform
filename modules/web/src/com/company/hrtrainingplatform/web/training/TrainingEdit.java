package com.company.hrtrainingplatform.web.training;

import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.hrtrainingplatform.entity.Training;
<<<<<<< HEAD

public class TrainingEdit extends AbstractEditor<Training> {
=======
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
    protected EmailService emailService;
    @Inject
    private Datasource<Training> trainingDs;

    public void onSendRequestClick() {

        User manager = trainingDs.getItem().getManager().getUser();

        showOptionDialog(
                "Email",
                "Send a training request email to manager " + manager.getName() + " ?",
                MessageType.CONFIRMATION,
                new Action[] {
                        new DialogAction(DialogAction.Type.YES) {
                            @Override
                            public void actionPerform(Component component) {
                                sendByEmail(manager.getEmail());
                            }
                        },
                        new DialogAction(DialogAction.Type.NO)
                }
        );
    }

    private void sendByEmail(String requestmail) {
        User currentUser= AppBeans.get(UserSessionSource.class).getUserSession().getUser();
        String trainingDesc = trainingDs.getItem().getDescription();
        UUID trainingID = trainingDs.getItem().getId();

        EmailInfo emailInfo = new EmailInfo(

                requestmail, // recipients
                "Training Request: "+ trainingDesc, // subject
                null, // the "from" address will be taken from the "cuba.email.fromAddress" app property

                "Training request for: \n"+"Full name: " + currentUser.getName()
                        +"\nuser ID: "+ currentUser.getLogin() + "\n Training :" + trainingDesc + "\n Training UUID:" + trainingID// body template


        );
        emailService.sendEmailAsync(emailInfo);
    }

>>>>>>> Test
}