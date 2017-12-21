-- begin HRTRAININGPLATFORM_ADDRESS
create table HRTRAININGPLATFORM_ADDRESS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
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
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ADDRESS_ID varchar(36) not null,
    LOCATION_NAME varchar(100) not null,
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_LOCATION
-- begin HRTRAININGPLATFORM_ADMIN
create table HRTRAININGPLATFORM_ADMIN (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_ADMIN
-- begin HRTRAININGPLATFORM_MANAGER
create table HRTRAININGPLATFORM_MANAGER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_MANAGER
-- begin HRTRAININGPLATFORM_HR_EMPLOYEE
create table HRTRAININGPLATFORM_HR_EMPLOYEE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_HR_EMPLOYEE
-- begin HRTRAININGPLATFORM_EMPLOYEE
create table HRTRAININGPLATFORM_EMPLOYEE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_ID varchar(36) not null,
    EMPLOYEE_ID integer,
    FIRST_NAME varchar(255),
    LAST_NAME varchar(255),
    MANAGER_ID varchar(36),
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_EMPLOYEE
-- begin HRTRAININGPLATFORM_SURVEY
create table HRTRAININGPLATFORM_SURVEY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TITLE varchar(255) not null,
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_SURVEY
-- begin HRTRAININGPLATFORM_CERTIFICATE
create table HRTRAININGPLATFORM_CERTIFICATE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DESCRIPTION varchar(100) not null,
    EMPLOYEE_ID varchar(36),
    FILE_ID varchar(36),
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_CERTIFICATE
-- begin HRTRAININGPLATFORM_TRAINING
create table HRTRAININGPLATFORM_TRAINING (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SURVEY_ID varchar(36),
    DESCRIPTION longvarchar not null,
    START_DATE date not null,
    END_DATE date not null,
    STATUS varchar(50) not null,
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_TRAINING
-- begin HRTRAININGPLATFORM_TRAINING_LOCATION_LINK
create table HRTRAININGPLATFORM_TRAINING_LOCATION_LINK (
    TRAINING_ID varchar(36) not null,
    LOCATION_ID varchar(36) not null,
    primary key (TRAINING_ID, LOCATION_ID)
)^
-- end HRTRAININGPLATFORM_TRAINING_LOCATION_LINK
-- begin HRTRAININGPLATFORM_TRAINING_EMPLOYEE_LINK
create table HRTRAININGPLATFORM_TRAINING_EMPLOYEE_LINK (
    TRAINING_ID varchar(36) not null,
    EMPLOYEE_ID varchar(36) not null,
    primary key (TRAINING_ID, EMPLOYEE_ID)
)^
-- end HRTRAININGPLATFORM_TRAINING_EMPLOYEE_LINK
-- begin HRTRAININGPLATFORM_ISB_NNR
create table HRTRAININGPLATFORM_ISB_NNR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ISBN varchar(20) not null,
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_ISB_NNR
-- begin HRTRAININGPLATFORM_QUESTION_CATEGORY
create table HRTRAININGPLATFORM_QUESTION_CATEGORY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(100),
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_QUESTION_CATEGORY
-- begin HRTRAININGPLATFORM_QUESTION
create table HRTRAININGPLATFORM_QUESTION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    QUESTION_TEXT varchar(255),
    DESCRIPTION varchar(255),
    CATEGORY_ID varchar(36),
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_QUESTION
-- begin HRTRAININGPLATFORM_POSSIBLE_ANSWER
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
)^
-- end HRTRAININGPLATFORM_POSSIBLE_ANSWER
-- begin HRTRAININGPLATFORM_FILLED_SURVEY
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
)^
-- end HRTRAININGPLATFORM_FILLED_SURVEY
-- begin HRTRAININGPLATFORM_SELECTED_ANSWER
create table HRTRAININGPLATFORM_SELECTED_ANSWER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    QUESTION_ID varchar(36) not null,
    ANSWER_ID varchar(36) not null,
    FILLED_SURVEY_ID varchar(36) not null,
    COMMENT_ varchar(255),
    --
    primary key (ID)
)^
-- end HRTRAININGPLATFORM_SELECTED_ANSWER
-- begin HRTRAININGPLATFORM_SURVEY_QUESTION_LINK
create table HRTRAININGPLATFORM_SURVEY_QUESTION_LINK (
    SURVEY_ID varchar(36) not null,
    QUESTION_ID varchar(36) not null,
    primary key (SURVEY_ID, QUESTION_ID)
)^
-- end HRTRAININGPLATFORM_SURVEY_QUESTION_LINK
-- begin HRTRAININGPLATFORM_TRAINING_ISB_NNR_LINK
create table HRTRAININGPLATFORM_TRAINING_ISB_NNR_LINK (
    TRAINING_ID varchar(36) not null,
    I_S_B_NNR_ID varchar(36) not null,
    primary key (TRAINING_ID, I_S_B_NNR_ID)
)^
-- end HRTRAININGPLATFORM_TRAINING_ISB_NNR_LINK
