alter table HRTRAININGPLATFORM_ADDRESS drop column POSTALCODE cascade ;
alter table HRTRAININGPLATFORM_ADDRESS add column POSTALCODE varchar(255) ^
update HRTRAININGPLATFORM_ADDRESS set POSTALCODE = '' where POSTALCODE is null ;
alter table HRTRAININGPLATFORM_ADDRESS alter column POSTALCODE set not null ;
