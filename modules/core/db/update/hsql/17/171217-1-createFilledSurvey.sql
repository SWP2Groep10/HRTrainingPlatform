create table HRTRAININGPLATFORM_FILLED_SURVEY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SURVEY_ID varchar(36) not null,
    FILLED_DATE date not null,
    USER_ID varchar(36) not null,
    --
    primary key (ID)
);
