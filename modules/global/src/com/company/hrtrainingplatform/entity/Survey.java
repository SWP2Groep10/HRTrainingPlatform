package com.company.hrtrainingplatform.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.Column;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|title")
@Table(name = "HRTRAININGPLATFORM_SURVEY")
@Entity(name = "hrtrainingplatform$Survey")
public class Survey extends StandardEntity {
    private static final long serialVersionUID = -6473592781886470744L;

    @Column(name = "TITLE", nullable = false)
    protected String title;

    @JoinTable(name = "HRTRAININGPLATFORM_SURVEY_QUESTION_LINK",
        joinColumns = @JoinColumn(name = "SURVEY_ID"),
        inverseJoinColumns = @JoinColumn(name = "QUESTION_ID"))
    @ManyToMany
    protected Set<Question> questions;

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Set<Question> getQuestions() {
        return questions;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


}