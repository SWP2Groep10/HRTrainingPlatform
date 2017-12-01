package com.company.hrtrainingplatform.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@NamePattern("%s|questionText")
@Table(name = "HRTRAININGPLATFORM_QUESTION")
@Entity(name = "hrtrainingplatform$Question")
public class Question extends StandardEntity {
    private static final long serialVersionUID = 8171513912141744846L;

    @Column(name = "QUESTION_TEXT")
    protected String questionText;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "question")
    protected Set<PossibleAnswer> possibleAnswers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    protected QuestionCategory category;

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setPossibleAnswers(Set<PossibleAnswer> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    public Set<PossibleAnswer> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setCategory(QuestionCategory category) {
        this.category = category;
    }

    public QuestionCategory getCategory() {
        return category;
    }


}