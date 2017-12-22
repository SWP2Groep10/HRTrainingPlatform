alter table HRTRAININGPLATFORM_EMPLOYEE add column HR_EMPLOYEE_ID varchar(36) ;
alter table HRTRAININGPLATFORM_EMPLOYEE drop column EMPLOYEE_ID cascade ;
alter table HRTRAININGPLATFORM_EMPLOYEE drop column FIRST_NAME cascade ;
alter table HRTRAININGPLATFORM_EMPLOYEE drop column LAST_NAME cascade ;
