-- alter table HRTRAININGPLATFORM_FILLED_SURVEY add column USER_ID varchar(32) ^
-- update HRTRAININGPLATFORM_FILLED_SURVEY set USER_ID = <default_value> ;
-- alter table HRTRAININGPLATFORM_FILLED_SURVEY modify column USER_ID varchar(32) not null ;
alter table HRTRAININGPLATFORM_FILLED_SURVEY add column USER_ID varchar(32) not null ;
alter table HRTRAININGPLATFORM_FILLED_SURVEY drop column EMPLOYEE_ID cascade ;
