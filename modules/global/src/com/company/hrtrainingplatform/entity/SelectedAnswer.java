package com.company.hrtrainingplatform.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@NamePattern("%s %s|question,possibleAnswer")
@Table(name = "HRTRAININGPLATFORM_SELECTED_ANSWER")
@Entity(name = "hrtrainingplatform$SelectedAnswer")
public class SelectedAnswer extends StandardEntity {
    private static final long serialVersionUID = -5397391897793809737L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FILLED_SURVEY_ID")
    protected FilledSurvey filledSurvey;

    @Column(name = "COMMENT_")
    protected String comment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "QUESTION_ID")
    protected Question question;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "POSSIBLE_ANSWER_ID")
    protected PossibleAnswer possibleAnswer;

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Question getQuestion() {
        return question;
    }

    public void setPossibleAnswer(PossibleAnswer possibleAnswer) {
        this.possibleAnswer = possibleAnswer;
    }

    public PossibleAnswer getPossibleAnswer() {
        return possibleAnswer;
    }


    public void setFilledSurvey(FilledSurvey filledSurvey) {
        this.filledSurvey = filledSurvey;
    }

    public FilledSurvey getFilledSurvey() {
        return filledSurvey;
    }


}