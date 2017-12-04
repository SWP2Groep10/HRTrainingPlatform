package com.company.hrtrainingplatform.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|isbn")
@Table(name = "HRTRAININGPLATFORM_ISB_NNR")
@Entity(name = "hrtrainingplatform$ISBNnr")
public class ISBNnr extends StandardEntity {
    private static final long serialVersionUID = -6180711945794456114L;

    @Pattern(message = "Not a valid ISBN number, please try again.", regexp = "^(?:(?:-1[03])?\\s)?(?=[-0-9\\s]{17}$|[-0-9X\\s]{13}$|[0-9X]{10}$)(?:97[89][-\\s]?)?[0-9]{1,5}[-\\s]?(?:[0-9]+[-\\s]?){2}[0-9X]$")
    @Column(name = "ISBN", nullable = false, length = 20)
    protected String isbn;

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }


}