create table HRTRAININGPLATFORM_FILLED_SURVEY (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    SURVEY_ID varchar(32) not null,
    FILLED_DATE date not null,
    EMPLOYEE_ID varchar(32) not null,
    --
    primary key (ID)
);
