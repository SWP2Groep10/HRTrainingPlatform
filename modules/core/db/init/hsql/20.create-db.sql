-- begin HRTRAININGPLATFORM_LOCATION
alter table HRTRAININGPLATFORM_LOCATION add constraint FK_HRTRAININGPLATFORM_LOCATION_ADDRESS foreign key (ADDRESS_ID) references HRTRAININGPLATFORM_ADDRESS(ID)^
create unique index IDX_HRTRAININGPLATFORM_LOCATION_UNIQ_LOCATION_NAME on HRTRAININGPLATFORM_LOCATION (LOCATION_NAME) ^
create index IDX_HRTRAININGPLATFORM_LOCATION_ADDRESS on HRTRAININGPLATFORM_LOCATION (ADDRESS_ID)^
-- end HRTRAININGPLATFORM_LOCATION
-- begin HRTRAININGPLATFORM_ADMIN
alter table HRTRAININGPLATFORM_ADMIN add constraint FK_HRTRAININGPLATFORM_ADMIN_USER foreign key (USER_ID) references SEC_USER(ID)^
create index IDX_HRTRAININGPLATFORM_ADMIN_USER on HRTRAININGPLATFORM_ADMIN (USER_ID)^
-- end HRTRAININGPLATFORM_ADMIN
-- begin HRTRAININGPLATFORM_MANAGER
alter table HRTRAININGPLATFORM_MANAGER add constraint FK_HRTRAININGPLATFORM_MANAGER_USER foreign key (USER_ID) references SEC_USER(ID)^
create index IDX_HRTRAININGPLATFORM_MANAGER_USER on HRTRAININGPLATFORM_MANAGER (USER_ID)^
-- end HRTRAININGPLATFORM_MANAGER
-- begin HRTRAININGPLATFORM_HR_EMPLOYEE
alter table HRTRAININGPLATFORM_HR_EMPLOYEE add constraint FK_HRTRAININGPLATFORM_HR_EMPLOYEE_USER foreign key (USER_ID) references SEC_USER(ID)^
create index IDX_HRTRAININGPLATFORM_HR_EMPLOYEE_USER on HRTRAININGPLATFORM_HR_EMPLOYEE (USER_ID)^
-- end HRTRAININGPLATFORM_HR_EMPLOYEE
-- begin HRTRAININGPLATFORM_EMPLOYEE
alter table HRTRAININGPLATFORM_EMPLOYEE add constraint FK_HRTRAININGPLATFORM_EMPLOYEE_USER foreign key (USER_ID) references SEC_USER(ID)^
alter table HRTRAININGPLATFORM_EMPLOYEE add constraint FK_HRTRAININGPLATFORM_EMPLOYEE_MANAGER foreign key (MANAGER_ID) references HRTRAININGPLATFORM_MANAGER(ID)^
create index IDX_HRTRAININGPLATFORM_EMPLOYEE_USER on HRTRAININGPLATFORM_EMPLOYEE (USER_ID)^
create index IDX_HRTRAININGPLATFORM_EMPLOYEE_MANAGER on HRTRAININGPLATFORM_EMPLOYEE (MANAGER_ID)^
-- end HRTRAININGPLATFORM_EMPLOYEE

-- begin HRTRAININGPLATFORM_TRAINING_LOCATION_LINK
alter table HRTRAININGPLATFORM_TRAINING_LOCATION_LINK add constraint FK_TRALOC_TRAINING foreign key (TRAINING_ID) references HRTRAININGPLATFORM_TRAINING(ID)^
alter table HRTRAININGPLATFORM_TRAINING_LOCATION_LINK add constraint FK_TRALOC_LOCATION foreign key (LOCATION_ID) references HRTRAININGPLATFORM_LOCATION(ID)^
-- end HRTRAININGPLATFORM_TRAINING_LOCATION_LINK
-- begin HRTRAININGPLATFORM_TRAINING_EMPLOYEE_LINK
alter table HRTRAININGPLATFORM_TRAINING_EMPLOYEE_LINK add constraint FK_TRAEMP_TRAINING foreign key (TRAINING_ID) references HRTRAININGPLATFORM_TRAINING(ID)^
alter table HRTRAININGPLATFORM_TRAINING_EMPLOYEE_LINK add constraint FK_TRAEMP_EMPLOYEE foreign key (EMPLOYEE_ID) references HRTRAININGPLATFORM_EMPLOYEE(ID)^
-- end HRTRAININGPLATFORM_TRAINING_EMPLOYEE_LINK
-- begin HRTRAININGPLATFORM_QUESTION
alter table HRTRAININGPLATFORM_QUESTION add constraint FK_HRTRAININGPLATFORM_QUESTION_CATEGORY foreign key (CATEGORY_ID) references HRTRAININGPLATFORM_QUESTION_CATEGORY(ID)^
create index IDX_HRTRAININGPLATFORM_QUESTION_CATEGORY on HRTRAININGPLATFORM_QUESTION (CATEGORY_ID)^
-- end HRTRAININGPLATFORM_QUESTION
-- begin HRTRAININGPLATFORM_POSSIBLE_ANSWER
alter table HRTRAININGPLATFORM_POSSIBLE_ANSWER add constraint FK_HRTRAININGPLATFORM_POSSIBLE_ANSWER_QUESTION foreign key (QUESTION_ID) references HRTRAININGPLATFORM_QUESTION(ID)^
create index IDX_HRTRAININGPLATFORM_POSSIBLE_ANSWER_QUESTION on HRTRAININGPLATFORM_POSSIBLE_ANSWER (QUESTION_ID)^
-- end HRTRAININGPLATFORM_POSSIBLE_ANSWER
-- begin HRTRAININGPLATFORM_FILLED_SURVEY
alter table HRTRAININGPLATFORM_FILLED_SURVEY add constraint FK_HRTRAININGPLATFORM_FILLED_SURVEY_SURVEY foreign key (SURVEY_ID) references HRTRAININGPLATFORM_SURVEY(ID)^
alter table HRTRAININGPLATFORM_FILLED_SURVEY add constraint FK_HRTRAININGPLATFORM_FILLED_SURVEY_USER foreign key (USER_ID) references SEC_USER(ID)^
create index IDX_HRTRAININGPLATFORM_FILLED_SURVEY_SURVEY on HRTRAININGPLATFORM_FILLED_SURVEY (SURVEY_ID)^
create index IDX_HRTRAININGPLATFORM_FILLED_SURVEY_USER on HRTRAININGPLATFORM_FILLED_SURVEY (USER_ID)^
-- end HRTRAININGPLATFORM_FILLED_SURVEY
-- begin HRTRAININGPLATFORM_SELECTED_ANSWER
alter table HRTRAININGPLATFORM_SELECTED_ANSWER add constraint FK_HRTRAININGPLATFORM_SELECTED_ANSWER_QUESTION foreign key (QUESTION_ID) references HRTRAININGPLATFORM_QUESTION(ID)^
alter table HRTRAININGPLATFORM_SELECTED_ANSWER add constraint FK_HRTRAININGPLATFORM_SELECTED_ANSWER_ANSWER foreign key (ANSWER_ID) references HRTRAININGPLATFORM_POSSIBLE_ANSWER(ID)^
alter table HRTRAININGPLATFORM_SELECTED_ANSWER add constraint FK_HRTRAININGPLATFORM_SELECTED_ANSWER_FILLED_SURVEY foreign key (FILLED_SURVEY_ID) references HRTRAININGPLATFORM_FILLED_SURVEY(ID)^
create index IDX_HRTRAININGPLATFORM_SELECTED_ANSWER_QUESTION on HRTRAININGPLATFORM_SELECTED_ANSWER (QUESTION_ID)^
create index IDX_HRTRAININGPLATFORM_SELECTED_ANSWER_ANSWER on HRTRAININGPLATFORM_SELECTED_ANSWER (ANSWER_ID)^
create index IDX_HRTRAININGPLATFORM_SELECTED_ANSWER_FILLED_SURVEY on HRTRAININGPLATFORM_SELECTED_ANSWER (FILLED_SURVEY_ID)^
-- end HRTRAININGPLATFORM_SELECTED_ANSWER
-- begin HRTRAININGPLATFORM_SURVEY_QUESTION_LINK
alter table HRTRAININGPLATFORM_SURVEY_QUESTION_LINK add constraint FK_SURQUE_SURVEY foreign key (SURVEY_ID) references HRTRAININGPLATFORM_SURVEY(ID)^
alter table HRTRAININGPLATFORM_SURVEY_QUESTION_LINK add constraint FK_SURQUE_QUESTION foreign key (QUESTION_ID) references HRTRAININGPLATFORM_QUESTION(ID)^
-- end HRTRAININGPLATFORM_SURVEY_QUESTION_LINK
-- begin HRTRAININGPLATFORM_TRAINING_ISB_NNR_LINK
alter table HRTRAININGPLATFORM_TRAINING_ISB_NNR_LINK add constraint FK_TRAISBNNR_TRAINING foreign key (TRAINING_ID) references HRTRAININGPLATFORM_TRAINING(ID)^
alter table HRTRAININGPLATFORM_TRAINING_ISB_NNR_LINK add constraint FK_TRAISBNNR_I_S_B_NNR foreign key (I_S_B_NNR_ID) references HRTRAININGPLATFORM_ISB_NNR(ID)^
-- end HRTRAININGPLATFORM_TRAINING_ISB_NNR_LINK
-- begin HRTRAININGPLATFORM_CERTIFICATE
alter table HRTRAININGPLATFORM_CERTIFICATE add constraint FK_HRTRAININGPLATFORM_CERTIFICATE_EMPLOYEE foreign key (EMPLOYEE_ID) references SEC_USER(ID)^
alter table HRTRAININGPLATFORM_CERTIFICATE add constraint FK_HRTRAININGPLATFORM_CERTIFICATE_FILE foreign key (FILE_ID) references SYS_FILE(ID)^
-- end HRTRAININGPLATFORM_CERTIFICATE
-- begin HRTRAININGPLATFORM_TRAINING
alter table HRTRAININGPLATFORM_TRAINING add constraint FK_HRTRAININGPLATFORM_TRAINING_SURVEY foreign key (SURVEY_ID) references HRTRAININGPLATFORM_SURVEY(ID)^
-- end HRTRAININGPLATFORM_TRAINING
