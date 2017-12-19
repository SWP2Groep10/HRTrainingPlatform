-- alter table HRTRAININGPLATFORM_TRAINING add column SURVEY_ID varchar(32) ^
-- update HRTRAININGPLATFORM_TRAINING set SURVEY_ID = <default_value> ;
-- alter table HRTRAININGPLATFORM_TRAINING modify column SURVEY_ID varchar(32) not null ;
alter table HRTRAININGPLATFORM_TRAINING add column SURVEY_ID varchar(32) not null ;
