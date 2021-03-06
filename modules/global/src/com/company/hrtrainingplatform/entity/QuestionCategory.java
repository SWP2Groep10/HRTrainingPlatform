package com.company.hrtrainingplatform.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@Table(name = "HRTRAININGPLATFORM_QUESTION_CATEGORY")
@Entity(name = "hrtrainingplatform$QuestionCategory")
public class QuestionCategory extends StandardEntity {
    private static final long serialVersionUID = 4547176124235969783L;

    @Column(name = "NAME", length = 100)
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}