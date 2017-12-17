alter table HRTRAININGPLATFORM_CERTIFICATE add column FILE_ID varchar(36) ;
-- alter table HRTRAININGPLATFORM_CERTIFICATE add column EMPLOYEE_ID varchar(36) ^
-- update HRTRAININGPLATFORM_CERTIFICATE set EMPLOYEE_ID = <default_value> ;
-- alter table HRTRAININGPLATFORM_CERTIFICATE alter column EMPLOYEE_ID set not null ;
alter table HRTRAININGPLATFORM_CERTIFICATE add column EMPLOYEE_ID varchar(36) not null ;
