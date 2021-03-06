package com.company.hrtrainingplatform.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|code")
@Table(name = "HRTRAININGPLATFORM_POSSIBLE_ANSWER")
@Entity(name = "hrtrainingplatform$PossibleAnswer")
public class PossibleAnswer extends StandardEntity {
    private static final long serialVersionUID = -1716616257715208609L;

    @Column(name = "CODE")
    protected String code;

    @Column(name = "ANSWER_TEXT")
    protected String answerText;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "QUESTION_ID")
    protected Question question;

    @Column(name = "ACTIVE")
    protected Boolean active;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Question getQuestion() {
        return question;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getActive() {
        return active;
    }


}