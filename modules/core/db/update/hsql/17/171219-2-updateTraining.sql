alter table HRTRAININGPLATFORM_TRAINING add column SURVEY_ID varchar(36) ;
alter table HRTRAININGPLATFORM_TRAINING drop column START_DATE cascade ;
alter table HRTRAININGPLATFORM_TRAINING add column START_DATE date ^
update HRTRAININGPLATFORM_TRAINING set START_DATE = current_date where START_DATE is null ;
alter table HRTRAININGPLATFORM_TRAINING alter column START_DATE set not null ;
alter table HRTRAININGPLATFORM_TRAINING drop column END_DATE cascade ;
alter table HRTRAININGPLATFORM_TRAINING add column END_DATE date ^
update HRTRAININGPLATFORM_TRAINING set END_DATE = current_date where END_DATE is null ;
alter table HRTRAININGPLATFORM_TRAINING alter column END_DATE set not null ;
