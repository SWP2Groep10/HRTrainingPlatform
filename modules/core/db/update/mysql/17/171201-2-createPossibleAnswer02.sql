alter table HRTRAININGPLATFORM_POSSIBLE_ANSWER add constraint FK_HRTRAININGPLATFORM_POSSIBLE_ANSWER_QUESTION foreign key (QUESTION_ID) references HRTRAININGPLATFORM_QUESTION(ID);
create index IDX_HRTRAININGPLATFORM_POSSIBLE_ANSWER_QUESTION on HRTRAININGPLATFORM_POSSIBLE_ANSWER (QUESTION_ID);
