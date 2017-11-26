-- begin HRTRAININGPLATFORM_ADDRESS
create table HRTRAININGPLATFORM_ADDRESS (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    COUNTRY varchar(100) not null,
    CITY varchar(100) not null,
    POSTALCODE varchar(255) not null,
    STREET varchar(100) not null,
    NUMBER_ integer not null,
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_ADDRESS
-- begin HRTRAININGPLATFORM_LOCATION
create table HRTRAININGPLATFORM_LOCATION (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    ADDRESS_ID varchar(32) not null,
    LOCATION_NAME varchar(100) not null,
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_LOCATION
-- begin HRTRAININGPLATFORM_ADMIN
create table HRTRAININGPLATFORM_ADMIN (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    USER_ID varchar(32) not null,
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_ADMIN
-- begin HRTRAININGPLATFORM_MANAGER
create table HRTRAININGPLATFORM_MANAGER (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    USER_ID varchar(32) not null,
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_MANAGER
-- begin HRTRAININGPLATFORM_HR_EMPLOYEE
create table HRTRAININGPLATFORM_HR_EMPLOYEE (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    USER_ID varchar(32) not null,
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_HR_EMPLOYEE
-- begin HRTRAININGPLATFORM_EMPLOYEE
create table HRTRAININGPLATFORM_EMPLOYEE (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    USER_ID varchar(32) not null,
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_EMPLOYEE
<<<<<<< HEAD
<<<<<<< HEAD

=======
-- begin HRTRAININGPLATFORM_SURVEY
create table HRTRAININGPLATFORM_SURVEY (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_SURVEY
>>>>>>> parent of ba4f4c5... survey class by Amir + Ricardo

=======
-- begin HRTRAININGPLATFORM_SURVEY
create table HRTRAININGPLATFORM_SURVEY (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_SURVEY
-- begin HRTRAININGPLATFORM_BOOK
create table HRTRAININGPLATFORM_BOOK (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    AUTHOR varchar(100) not null,
    COST decimal(19, 2) not null,
    ISBN varchar(50) not null,
    PUBLISHER varchar(100) not null,
    TITLE varchar(100) not null,
    YEAR_ varchar(255) not null,
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_BOOK
>>>>>>> parent of 957ec06... Merge branch 'master' into Amir
-- begin HRTRAININGPLATFORM_CERTIFICATE
create table HRTRAININGPLATFORM_CERTIFICATE (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    DESCRIPTION varchar(100) not null,
    FILE_ID varchar(32),
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_CERTIFICATE
-- begin HRTRAININGPLATFORM_TRAINING
create table HRTRAININGPLATFORM_TRAINING (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    DESCRIPTION varchar(100) not null,
    START_DATE datetime(3) not null,
    END_DATE datetime(3) not null,
    STATUS varchar(50) not null,
    SURVEY_ID varchar(32) not null,
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_TRAINING
-- begin HRTRAININGPLATFORM_TRAINING_LOCATION_LINK
create table HRTRAININGPLATFORM_TRAINING_LOCATION_LINK (
    TRAINING_ID varchar(32),
    LOCATION_ID varchar(32),
    primary key (TRAINING_ID, LOCATION_ID)
)^
-- end HRTRAININGPLATFORM_TRAINING_LOCATION_LINK
-- begin HRTRAININGPLATFORM_TRAINING_EMPLOYEE_LINK
create table HRTRAININGPLATFORM_TRAINING_EMPLOYEE_LINK (
    TRAINING_ID varchar(32),
    EMPLOYEE_ID varchar(32),
    primary key (TRAINING_ID, EMPLOYEE_ID)
)^
-- end HRTRAININGPLATFORM_TRAINING_EMPLOYEE_LINK
