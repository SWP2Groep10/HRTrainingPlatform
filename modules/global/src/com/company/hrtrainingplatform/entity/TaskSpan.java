package com.company.hrtrainingplatform.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|category")
@Table(name = "HRTRAININGPLATFORM_TASK_SPAN")
@Entity(name = "hrtrainingplatform$TaskSpan")
public class TaskSpan extends StandardEntity {
    private static final long serialVersionUID = -6062399872033320605L;

    @OneToMany(mappedBy = "taskSpan")
    protected List<Training> dateSegments;

    @Column(name = "CATEGORY")
    protected String category;

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }


    public void setDateSegments(List<Training> dateSegments) {
        this.dateSegments = dateSegments;
    }

    public List<Training> getDateSegments() {
        return dateSegments;
    }


}