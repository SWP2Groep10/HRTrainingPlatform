alter table HRTRAININGPLATFORM_SURVEY_QUESTION_LINK add constraint FK_SURQUE_SURVEY foreign key (SURVEY_ID) references HRTRAININGPLATFORM_SURVEY(ID);
alter table HRTRAININGPLATFORM_SURVEY_QUESTION_LINK add constraint FK_SURQUE_QUESTION foreign key (QUESTION_ID) references HRTRAININGPLATFORM_QUESTION(ID);