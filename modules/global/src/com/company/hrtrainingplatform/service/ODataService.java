package com.company.hrtrainingplatform.service;


import com.company.hrtrainingplatform.entity.Employee;

import java.util.Set;

public interface ODataService {
    String NAME = "hrtrainingplatform_ODataService";

    Set<Employee> getEmployees(String ODataURL);
}