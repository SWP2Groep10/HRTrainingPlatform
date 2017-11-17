package com.company.hrtrainingplatform.web.employee;

import com.haulmont.cuba.gui.components.EntityCombinedScreen;
import com.haulmont.cuba.gui.components.Component;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.*;

public class EmployeeBrowse extends EntityCombinedScreen{
    public void onOData(Component source)throws IOException{
        URL oData = new URL("http://services.odata.org/V3/Northwind/Northwind.svc/Employees?$format=json");
        InputStream is = oData.openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            String jsonText = sb.toString();
            JSONObject json = new JSONObject(jsonText);
            showNotification(json.toString());
        } catch(Exception e) {
            showNotification(e.getMessage());
        } finally {
            is.close();
        }
    }
}