create table HRTRAININGPLATFORM_TASK_SPAN (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TASK_SPAN_ID varchar(36),
    YEAR_ integer,
    MONTH_ integer,
    DAY_ integer,
    --
    primary key (ID)
);
