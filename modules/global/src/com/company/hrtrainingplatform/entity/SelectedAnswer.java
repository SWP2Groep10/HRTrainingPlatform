package com.company.hrtrainingplatform.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s %s|question,answer")
@Table(name = "HRTRAININGPLATFORM_SELECTED_ANSWER")
@Entity(name = "hrtrainingplatform$SelectedAnswer")
public class SelectedAnswer extends StandardEntity {
    private static final long serialVersionUID = -8580752837418862754L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "QUESTION_ID")
    protected Question question;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ANSWER_ID")
    protected PossibleAnswer answer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FILLED_SURVEY_ID")
    protected FilledSurvey filledSurvey;

    @Column(name = "COMMENT_")
    protected String comment;

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Question getQuestion() {
        return question;
    }

    public void setAnswer(PossibleAnswer answer) {
        this.answer = answer;
    }

    public PossibleAnswer getAnswer() {
        return answer;
    }

    public void setFilledSurvey(FilledSurvey filledSurvey) {
        this.filledSurvey = filledSurvey;
    }

    public FilledSurvey getFilledSurvey() {
        return filledSurvey;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }


}