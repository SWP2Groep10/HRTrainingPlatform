package com.company.hrtrainingplatform.core;


import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.EmailInfo;
import com.haulmont.cuba.security.app.Authenticated;
import groovy.transform.ToString;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.text.DateFormat;
import java.util.Iterator;
import java.util.List;

@Component(ReminderMailCheckComponent.NAME)
public class ReminderMailCheckBean implements ReminderMailCheckComponent {

    @Inject
    protected EmailService emailService;
    @Inject
    private Persistence persistence;

    @Authenticated
    @Transactional
    @Override
    public void checkReminders(){
        Query query = persistence.getEntityManager().createNativeQuery(
                "select s.email,s.name,t.description,t.START_DATE,t.END_DATE\n" +
                        "from HRTRAININGPLATFORM_TRAINING t,HRTRAININGPLATFORM_TRAINING_EMPLOYEE_LINK l,HRTRAININGPLATFORM_EMPLOYEE e,SEC_USER s\n" +
                        "where l.TRAINING_ID=t.ID and l.EMPLOYEE_ID=e.ID and e.USER_ID=s.ID and CURRENT_DATE=DATE_SUB(CAST(t.START_DATE AS DATE), INTERVAL 1 DAY)");

        List list = query.getResultList();


        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Object[] row = (Object[]) it.next();
            String email = (String) row[0];
            String empName = (String) row[1];
            String trainigDesc = (String) row[2];
            String start_date = row[3].toString();
            String end_date = row[4].toString();
            sendByEmail(email,empName,trainigDesc,start_date,end_date);
        }
    }

    // MAIL FUNCTIONALITY
    private void sendByEmail(String email, String empName, String trainingDesc, String start_date, String end_date) {

        EmailInfo emailInfo = new EmailInfo(
                email,
                "Training Reminder: "+ trainingDesc, // subject
                null, // the "from" address will be taken from the "cuba.email.fromAddress" app property

                "Hello "+empName+",\n\nThis is a reminder for your upcoming training: "+trainingDesc+"\nThis training takes place on "
                        +start_date+" and ends on "+end_date+".\n\nThis is a no-reply mail\nHave a nice day."// body template
        );
        emailService.sendEmailAsync(emailInfo);
    }
}