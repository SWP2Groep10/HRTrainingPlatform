update HRTRAININGPLATFORM_POSSIBLE_ANSWER set ANSWER_TEXT = '' where ANSWER_TEXT is null ;
alter table HRTRAININGPLATFORM_POSSIBLE_ANSWER alter column ANSWER_TEXT set not null ;
