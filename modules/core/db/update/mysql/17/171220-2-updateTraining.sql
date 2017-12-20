alter table HRTRAININGPLATFORM_TRAINING drop column START_DATE cascade ;
alter table HRTRAININGPLATFORM_TRAINING add column START_DATE datetime(3) ^
update HRTRAININGPLATFORM_TRAINING set START_DATE = current_timestamp where START_DATE is null ;
alter table HRTRAININGPLATFORM_TRAINING modify column START_DATE datetime(3) not null ;
alter table HRTRAININGPLATFORM_TRAINING drop column END_DATE cascade ;
alter table HRTRAININGPLATFORM_TRAINING add column END_DATE datetime(3) ^
update HRTRAININGPLATFORM_TRAINING set END_DATE = current_timestamp where END_DATE is null ;
alter table HRTRAININGPLATFORM_TRAINING modify column END_DATE datetime(3) not null ;
