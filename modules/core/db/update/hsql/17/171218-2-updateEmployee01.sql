alter table HRTRAININGPLATFORM_EMPLOYEE add column MANAGER_ID varchar(36) ;
alter table HRTRAININGPLATFORM_EMPLOYEE drop column FIRST_NAME cascade ;
alter table HRTRAININGPLATFORM_EMPLOYEE drop column LAST_NAME cascade ;
