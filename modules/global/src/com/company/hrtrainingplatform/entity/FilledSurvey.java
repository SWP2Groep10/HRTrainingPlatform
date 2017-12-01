package com.company.hrtrainingplatform.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.security.entity.User;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamePattern("%s %s|filledDate,survey")
@Table(name = "HRTRAININGPLATFORM_FILLED_SURVEY")
@Entity(name = "hrtrainingplatform$FilledSurvey")
public class FilledSurvey extends StandardEntity {
    private static final long serialVersionUID = 5651143472919513460L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SURVEY_ID")
    protected Survey survey;

    @Temporal(TemporalType.DATE)
    @Column(name = "FILLED_DATE", nullable = false)
    protected Date filledDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID")
    protected User user;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "filledSurvey")
    protected Set<SelectedAnswer> answers;

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setFilledDate(Date filledDate) {
        this.filledDate = filledDate;
    }

    public Date getFilledDate() {
        return filledDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setAnswers(Set<SelectedAnswer> answers) {
        this.answers = answers;
    }

    public Set<SelectedAnswer> getAnswers() {
        return answers;
    }


}