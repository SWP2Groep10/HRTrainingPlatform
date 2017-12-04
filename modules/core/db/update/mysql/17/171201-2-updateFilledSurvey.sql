alter table HRTRAININGPLATFORM_FILLED_SURVEY drop column EMPLOYEE_ID cascade ;
alter table HRTRAININGPLATFORM_FILLED_SURVEY add column EMPLOYEE_ID varchar(32) ;
alter table HRTRAININGPLATFORM_FILLED_SURVEY modify column EMPLOYEE_ID varchar(32) null ;
