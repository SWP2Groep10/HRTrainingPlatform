create table HRTRAININGPLATFORM_POSSIBLE_ANSWER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CODE varchar(255),
    ANSWER_TEXT varchar(255),
    QUESTION_ID varchar(36) not null,
    ACTIVE boolean,
    --
    primary key (ID)
);
