package com.company.hrtrainingplatform.web.employee;

import com.company.hrtrainingplatform.entity.Employee;
import com.company.hrtrainingplatform.service.ODataService;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.gui.data.impl.CustomCollectionDatasource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;


public class ODataDatasource extends CustomCollectionDatasource<Employee, UUID> {
    private ODataService oDataService = AppBeans.get(ODataService.NAME);
    @Override
    protected Collection<Employee> getEntities(Map<String, Object> params) {
        if(oDataService != null){
            ArrayList<Employee> employees = oDataService.getEmployees("http://services.odata.org/V3/Northwind/Northwind.svc/Employees?$format=json");
            for(int i = 0; i < employees.size(); i++){
                System.out.println(employees.get(i).getFirstName());
            }
            return employees;
        } else {
            return new ArrayList<>();
        }
    }
}