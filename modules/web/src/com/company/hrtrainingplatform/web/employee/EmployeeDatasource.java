package com.company.hrtrainingplatform.web.employee;

import com.company.hrtrainingplatform.entity.Employee;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.gui.data.impl.CustomCollectionDatasource;
import com.company.hrtrainingplatform.service.ODataService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;


public class EmployeeDatasource extends CustomCollectionDatasource<Employee, UUID> {
    private ODataService oDataService = AppBeans.get(ODataService.NAME);

    @Override
    protected Collection<Employee> getEntities(Map<String, Object> params) {
        if(oDataService != null){
            return oDataService.getEmployees("http://services.odata.org/V3/Northwind/Northwind.svc/Employees?$format=json");
        } else {
            return new HashSet<>();
        }
    }
}