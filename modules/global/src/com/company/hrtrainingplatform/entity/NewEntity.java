package com.company.hrtrainingplatform.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|id")
@Table(name = "HRTRAININGPLATFORM_NEW_ENTITY")
@Entity(name = "hrtrainingplatform$NewEntity")
public class NewEntity extends StandardEntity {
    private static final long serialVersionUID = -8230557738017219196L;

}