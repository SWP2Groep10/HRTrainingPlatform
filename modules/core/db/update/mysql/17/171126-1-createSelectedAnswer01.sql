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
    FILLED_SURVEY_ID varchar(32) not null,
    COMMENT_ varchar(255),
    QUESTION_ID varchar(32) not null,
    POSSIBLE_ANSWER_ID varchar(32) not null,
    --
    primary key (ID)
);
