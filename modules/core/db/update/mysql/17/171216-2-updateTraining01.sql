-- alter table HRTRAININGPLATFORM_TRAINING add column MANAGER_ID varchar(32) ^
-- update HRTRAININGPLATFORM_TRAINING set MANAGER_ID = <default_value> ;
-- alter table HRTRAININGPLATFORM_TRAINING modify column MANAGER_ID varchar(32) not null ;
alter table HRTRAININGPLATFORM_TRAINING add column MANAGER_ID varchar(32) not null ;
