-- alter table HRTRAININGPLATFORM_TRAINING add column MANAGER_ID varchar(36) ^
-- update HRTRAININGPLATFORM_TRAINING set MANAGER_ID = <default_value> ;
-- alter table HRTRAININGPLATFORM_TRAINING alter column MANAGER_ID set not null ;
alter table HRTRAININGPLATFORM_TRAINING add column MANAGER_ID varchar(36) not null ;
alter table HRTRAININGPLATFORM_TRAINING alter column DESCRIPTION set data type longvarchar ;
alter table HRTRAININGPLATFORM_TRAINING alter column SURVEY_ID set null ;
