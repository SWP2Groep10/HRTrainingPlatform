alter table SEC_USER add constraint FK_SEC_USER_MANAGER foreign key (MANAGER_ID) references HRTRAININGPLATFORM_MANAGER(ID);
create index IDX_SEC_USER_MANAGER on SEC_USER (MANAGER_ID);
