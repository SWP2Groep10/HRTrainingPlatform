alter table HRTRAININGPLATFORM_CERTIFICATE add constraint FK_HRTRAININGPLATFORM_CERTIFICATE_FILE foreign key (FILE_ID) references SYS_FILE(ID);
