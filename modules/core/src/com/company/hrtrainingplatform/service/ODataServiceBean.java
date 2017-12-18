package com.company.hrtrainingplatform.service;

import com.company.hrtrainingplatform.entity.Employee;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;

@Service(ODataService.NAME)
public class ODataServiceBean implements ODataService {
    @Override
    public HashSet<Employee> getEmployees(String ODataURL){
        HashSet<Employee> result = new HashSet<>();
        StringBuilder json = new StringBuilder();
        try{
            URL url = new URL(ODataURL);
            URLConnection connection = url.openConnection();
            try(InputStream in = connection.getInputStream()){
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line;
                while((line = reader.readLine()) != null){
                    json.append(line).append("\n");
                }
            }
        } catch (IOException e){
            e.printStackTrace();
            return result;
        }
        JSONObject response = new JSONObject(json.toString());
        JSONArray employees = response.getJSONArray("value");

        for(int i = 0; i < employees.length(); i++){
            JSONObject employee;

            try{
                employee = employees.getJSONObject(i);
            } catch (JSONException e){
                employee = null;
            }

            if(employee != null){
                Employee e = new Employee();
                e.getUser().setFirstName(employee.getString("FirstName"));
                e.getUser().setLastName(employee.getString("LastName"));
                e.setFirstName(employee.getString("FirstName"));
                e.setLastName(employee.getString("LastName"));
                e.getUser().setLogin(employee.getInt("EmployeeID")+"");
                result.add(e);
                System.out.println(e.getFirstName());
            }
        }

        return result;
    }

    @Override
    public Employee getEmployee(int EmployeeID, String ODataURL){
        Employee result = new Employee();
        StringBuilder json = new StringBuilder();
        //http://services.odata.org/V3/Northwind/Northwind.svc/Employees?$format=json&$filter=EmployeeID eq 2
        String ODataQuery = ODataURL;
        if(!ODataQuery.contains("?")){
            ODataQuery = ODataQuery + "?";
        } else {
            ODataQuery = ODataQuery + "&";
        }

        try{
            URL url = new URL(ODataQuery + "$filter=EmployeeID eq " + EmployeeID);
            URLConnection connection = url.openConnection();
            try(InputStream in = connection.getInputStream()){
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line;
                while((line = reader.readLine()) != null){
                    json.append(line).append("\n");
                }
            }
        } catch (IOException e){
            e.printStackTrace();
            return result;
        }
        JSONObject response = new JSONObject(json.toString());
        JSONArray employees = response.getJSONArray("value");

        for(int i = 0; i < employees.length(); i++){
            JSONObject employee;

            try{
                employee = employees.getJSONObject(i);
            } catch (JSONException e){
                employee = null;
            }

            if(employee != null){
                result.getUser().setFirstName(employee.getString("FirstName"));
                result.getUser().setLastName(employee.getString("LastName"));
                result.setFirstName(employee.getString("FirstName"));
                result.setLastName(employee.getString("LastName"));
                result.getUser().setLogin(employee.getInt("EmployeeID")+"");
            }
        }

        return result;
    }
}