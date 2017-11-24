update HRTRAININGPLATFORM_TRAINING set DESCRIPTION = '' where DESCRIPTION is null ;
alter table HRTRAININGPLATFORM_TRAINING modify column DESCRIPTION longtext not null ;
