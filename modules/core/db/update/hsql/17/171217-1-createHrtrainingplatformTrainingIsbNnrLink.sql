create table HRTRAININGPLATFORM_TRAINING_ISB_NNR_LINK (
    TRAINING_ID varchar(36) not null,
    I_S_B_NNR_ID varchar(36) not null,
    primary key (TRAINING_ID, I_S_B_NNR_ID)
);
