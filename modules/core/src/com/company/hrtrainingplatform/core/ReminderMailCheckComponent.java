package com.company.hrtrainingplatform.core;

import com.haulmont.cuba.security.app.Authenticated;
import org.springframework.transaction.annotation.Transactional;


public interface ReminderMailCheckComponent {
    String NAME = "hrtrainingplatform_ReminderMailCheckComponent";

    @Authenticated
    @Transactional
    void checkReminders();
}
