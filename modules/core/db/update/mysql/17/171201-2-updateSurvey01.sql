alter table HRTRAININGPLATFORM_SURVEY add column TITLE varchar(255) ^
update HRTRAININGPLATFORM_SURVEY set TITLE = '' where TITLE is null ;
alter table HRTRAININGPLATFORM_SURVEY modify column TITLE varchar(255) not null ;
