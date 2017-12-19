-- alter table HRTRAININGPLATFORM_CERTIFICATE add column EMPLOYEE_ID varchar(32) ^
-- update HRTRAININGPLATFORM_CERTIFICATE set EMPLOYEE_ID = <default_value> ;
-- alter table HRTRAININGPLATFORM_CERTIFICATE modify column EMPLOYEE_ID varchar(32) not null ;
alter table HRTRAININGPLATFORM_CERTIFICATE add column EMPLOYEE_ID varchar(32) not null ;
