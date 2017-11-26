alter table HRTRAININGPLATFORM_SELECTED_ANSWER add constraint FK_HRTRAININGPLATFORM_SELECTED_ANSWER_FILLED_SURVEY foreign key (FILLED_SURVEY_ID) references HRTRAININGPLATFORM_FILLED_SURVEY(ID);
alter table HRTRAININGPLATFORM_SELECTED_ANSWER add constraint FK_HRTRAININGPLATFORM_SELECTED_ANSWER_QUESTION foreign key (QUESTION_ID) references HRTRAININGPLATFORM_QUESTION(ID);
alter table HRTRAININGPLATFORM_SELECTED_ANSWER add constraint FK_HRTRAININGPLATFORM_SELECTED_ANSWER_POSSIBLE_ANSWER foreign key (POSSIBLE_ANSWER_ID) references HRTRAININGPLATFORM_POSSIBLE_ANSWER(ID);
create index IDX_HRTRAININGPLATFORM_SELECTED_ANSWER_FILLED_SURVEY on HRTRAININGPLATFORM_SELECTED_ANSWER (FILLED_SURVEY_ID);
create index IDX_HRTRAININGPLATFORM_SELECTED_ANSWER_QUESTION on HRTRAININGPLATFORM_SELECTED_ANSWER (QUESTION_ID);
create index IDX_HRTRAININGPLATFORM_SELECTED_ANSWER_POSSIBLE_ANSWER on HRTRAININGPLATFORM_SELECTED_ANSWER (POSSIBLE_ANSWER_ID);
