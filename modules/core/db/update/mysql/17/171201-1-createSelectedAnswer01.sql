create table HRTRAININGPLATFORM_SELECTED_ANSWER (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    QUESTION_ID varchar(32) not null,
    ANSWER_ID varchar(32) not null,
    FILLED_SURVEY_ID varchar(32) not null,
    COMMENT_ varchar(255),
    --
    primary key (ID)
);
