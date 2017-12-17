-- update HRTRAININGPLATFORM_CERTIFICATE set EMPLOYEE_ID = <default_value> where EMPLOYEE_ID is null ;
alter table HRTRAININGPLATFORM_CERTIFICATE modify column EMPLOYEE_ID varchar(32) not null ;
