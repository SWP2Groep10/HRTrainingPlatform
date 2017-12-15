-- update HRTRAININGPLATFORM_TRAINING set MANAGER_ID = <default_value> where MANAGER_ID is null ;
alter table HRTRAININGPLATFORM_TRAINING modify column MANAGER_ID varchar(32) not null ;
