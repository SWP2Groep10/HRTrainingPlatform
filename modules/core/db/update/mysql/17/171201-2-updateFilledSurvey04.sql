alter table HRTRAININGPLATFORM_FILLED_SURVEY add column EMPLOYEE_ID varchar(32) ;
alter table HRTRAININGPLATFORM_FILLED_SURVEY drop column USER_ID cascade ;
