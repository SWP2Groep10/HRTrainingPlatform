alter table HRTRAININGPLATFORM_FILLED_SURVEY add constraint FK_HRTRAININGPLATFORM_FILLED_SURVEY_USER foreign key (USER_ID) references SEC_USER(ID);
create index IDX_HRTRAININGPLATFORM_FILLED_SURVEY_USER on HRTRAININGPLATFORM_FILLED_SURVEY (USER_ID);
