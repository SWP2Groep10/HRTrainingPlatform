package com.company.hrtrainingplatform.service;


import com.company.hrtrainingplatform.entity.Employee;
import java.util.HashSet;

public interface ODataService {
    String NAME = "hrtrainingplatform_ODataService";
    HashSet<Employee> getEmployees(String ODataURL);
}