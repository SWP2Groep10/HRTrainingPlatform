package com.company.hrtrainingplatform.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|description")
@Table(name = "HRTRAININGPLATFORM_CERTIFICATE")
@Entity(name = "hrtrainingplatform$Certificate")
public class Certificate extends StandardEntity {
    private static final long serialVersionUID = 8658170452982695634L;

    @NotNull(message = "This value can not be null")
    @Column(name = "DESCRIPTION", nullable = false, length = 100)
    protected String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


}