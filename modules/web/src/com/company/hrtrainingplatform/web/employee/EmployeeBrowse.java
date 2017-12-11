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
import javax.inject.Inject;
import javax.persistence.*;
import javax.persistence.EntityManager;

import org.json.*;

public class EmployeeBrowse extends EntityCombinedScreen {
    public void onOData(Component source) throws IOException {
        JSONObject json;
        URL oData = new URL("http://services.odata.org/V3/Northwind/Northwind.svc/Employees?$format=json");
        //Binnenhalen van de odata en omzetten naar een JSON
        InputStream is = oData.openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            String jsonText = sb.toString();
            json = new JSONObject(jsonText);
            //showNotification(json.toString();
        } catch (Exception e) {
            showNotification(e.getMessage());
            json = null;
        } finally {
            is.close();
        }
        //Omzetten van de data voor gebruik
        if (json != null) {
            JSONArray data = json.getJSONArray("value");
            String[] firstNames = new String[data.length()];
            for (int i = 0; i < data.length(); i++) {
                JSONObject temp = data.getJSONObject(i);
                firstNames[i] = temp.getString("FirstName");
            }
            User u = new User();
            u.setFirstName(data.getJSONObject(1).getString("FirstName"));
            u.setLoginLowerCase(data.getJSONObject(1).getString("FirstName"));
            u.setPassword(data.getJSONObject(1).getString("FirstName"));
            //UUID id = UUID.fromString("d04c525712a9efe686e7b19fa078433d");
            //List<Group> groups = loadGroups();
            Group g = new Group();
            g.setName("Employee");
            u.setGroup(g);
            


            //showNotification(firstNames[1]);
            //showNotification(groups.toString());
        } else {
            showNotification("Boy, this didn't work");
        }
    }

    protected List<Group> loadGroups() {
        Group g = null;
        LoadContext<Group> group = LoadContext.create(Group.class).setQuery(LoadContext.createQuery("SELECT * FROM SP2Team10.SEC_GROUP WHERE ID = ?ID").setParameter("ID", "d04c525712a9efe686e7b19fa078433d")).setView("group-view");
        /*TypedQuery<Group> query = EntityManager.createQuery("select * from SP2Team10.SEC_GROUP where ID = ?groupID", Group.class);
        query.setParameter(groupID, customer);*/
        DataManager dm = null;

        return dm.loadList(group);
    }
}

/*
(╯°□°)╯︵ ┻━┻ FLIP THAT TABLE.

┻━┻ ︵ ヽ(°□°ヽ) FLIP THIS TABLE.

┻━┻ ︵ ＼\('0')/／ ︵ ┻━┻

FLIP ALL THE TABLES!

ಠ_ಠ Tom...

ಠ_ಠ Put.

ಠ__ಠ The tables.

ಠ___ಠ Back.

(╮°-°)╮┳━┳

(╯°□°)╯︵ ┻━┻ NEVER!﻿
*/