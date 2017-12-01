alter table HRTRAININGPLATFORM_FILLED_SURVEY add column USER_ID varchar(32) ;
alter table HRTRAININGPLATFORM_FILLED_SURVEY drop column EMPLOYEE_ID cascade ;
