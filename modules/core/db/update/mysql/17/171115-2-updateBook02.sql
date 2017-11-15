alter table HRTRAININGPLATFORM_BOOK drop column YEAR_ cascade ;
alter table HRTRAININGPLATFORM_BOOK add column YEAR_ varchar(255) ^
update HRTRAININGPLATFORM_BOOK set YEAR_ = '' where YEAR_ is null ;
alter table HRTRAININGPLATFORM_BOOK modify column YEAR_ varchar(255) not null ;
