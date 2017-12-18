package com.company.hrtrainingplatform.service;


import com.company.hrtrainingplatform.entity.Employee;

import java.util.ArrayList;
import java.util.HashSet;

public interface ODataService {
    String NAME = "hrtrainingplatform_ODataService";
    ArrayList<Employee> getEmployees(String ODataURL);
    Employee getEmployee(int EmployeeID, String ODataURL);
}