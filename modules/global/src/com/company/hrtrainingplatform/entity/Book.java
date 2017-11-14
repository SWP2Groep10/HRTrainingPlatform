package com.company.hrtrainingplatform.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s %s|title,author")
@Table(name = "HRTRAININGPLATFORM_BOOK")
@Entity(name = "hrtrainingplatform$Book")
public class Book extends StandardEntity {
    private static final long serialVersionUID = -8251120800986885937L;

    @NotNull(message = "This value can not be null")
    @Column(name = "AUTHOR", nullable = false, length = 100)
    protected String author;

    @NotNull(message = "This value can not be null")
    @Column(name = "COST", nullable = false)
    protected BigDecimal cost;

    @NotNull(message = "This value can not be null")
    @Column(name = "ISBN", nullable = false, length = 50)
    protected String isbn;

    @NotNull(message = "This value can not be null")
    @Column(name = "PUBLISHER", nullable = false, length = 100)
    protected String publisher;

    @NotNull(message = "This value can not be null")
    @Column(name = "TITLE", nullable = false, length = 100)
    protected String title;

    @NotNull(message = "This value can not be null")
    @Column(name = "YEAR_", nullable = false)
    protected Integer year;

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getYear() {
        return year;
    }


    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }


}