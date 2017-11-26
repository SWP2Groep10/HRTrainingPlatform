package com.company.hrtrainingplatform.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.Column;

@NamePattern("%s|name")
@Table(name = "HRTRAININGPLATFORM_QUESTION_CATEGORY")
@Entity(name = "hrtrainingplatform$QuestionCategory")
public class QuestionCategory extends StandardEntity {
    private static final long serialVersionUID = 229145958775852758L;

    @Column(name = "NAME")
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}