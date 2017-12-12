-- update HRTRAININGPLATFORM_TRAINING set SURVEY_ID = <default_value> where SURVEY_ID is null ;
alter table HRTRAININGPLATFORM_TRAINING modify column SURVEY_ID varchar(32) not null ;
