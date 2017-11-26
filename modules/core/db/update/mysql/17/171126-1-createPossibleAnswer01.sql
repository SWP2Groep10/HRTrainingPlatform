create table HRTRAININGPLATFORM_POSSIBLE_ANSWER (
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
    ACTIVE boolean,
    CODE varchar(255),
    ANSWER_TEXT varchar(255),
    --
    primary key (ID)
);
