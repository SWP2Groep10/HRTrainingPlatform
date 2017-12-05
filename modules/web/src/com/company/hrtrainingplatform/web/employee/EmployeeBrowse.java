package com.company.hrtrainingplatform.web.employee;

import com.company.hrtrainingplatform.entity.Employee;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.components.EntityCombinedScreen;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.security.entity.Group;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import javax.persistence.EntityManager;

import org.json.*;

public class EmployeeBrowse extends EntityCombinedScreen {
    public void onOData(Component source) throws IOException {

    }
}