create table HRTRAININGPLATFORM_SURVEY_QUESTION_LINK (
    SURVEY_ID varchar(36) not null,
    QUESTION_ID varchar(36) not null,
    primary key (SURVEY_ID, QUESTION_ID)
);
