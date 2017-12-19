package com.company.hrtrainingplatform.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import javax.persistence.Lob;

@NamePattern("%s %s|description,status")
@Table(name = "HRTRAININGPLATFORM_TRAINING")
@Entity(name = "hrtrainingplatform$Training")
public class Training extends StandardEntity {
    private static final long serialVersionUID = 2831799128035995203L;

    @NotNull(message = "Training can't be given without any attending employees")
    @JoinTable(name = "HRTRAININGPLATFORM_TRAINING_EMPLOYEE_LINK",
        joinColumns = @JoinColumn(name = "TRAINING_ID"),
        inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
    @ManyToMany
    protected List<Employee> attendingList;

    @JoinTable(name = "HRTRAININGPLATFORM_TRAINING_ISB_NNR_LINK",
        joinColumns = @JoinColumn(name = "TRAINING_ID"),
        inverseJoinColumns = @JoinColumn(name = "I_S_B_NNR_ID"))
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToMany
    protected List<ISBNnr> recBookList;

    @NotNull(message = "Training's require descriptions")
    @Lob
    @Column(name = "DESCRIPTION", nullable = false)
    protected String description;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "This value can not be null")
    @Column(name = "START_DATE", nullable = false)
    protected Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "This value can not be null")
    @Column(name = "END_DATE", nullable = false)
    protected Date endDate;

    @NotNull(message = "Location is required.")
    @JoinTable(name = "HRTRAININGPLATFORM_TRAINING_LOCATION_LINK",
        joinColumns = @JoinColumn(name = "TRAINING_ID"),
        inverseJoinColumns = @JoinColumn(name = "LOCATION_ID"))
    @ManyToMany
    protected List<Location> location;

    @Column(name = "STATUS", nullable = false)
    protected String status;

    public void setRecBookList(List<ISBNnr> recBookList) {
        this.recBookList = recBookList;
    }

    public List<ISBNnr> getRecBookList() {
        return recBookList;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    public void setAttendingList(List<Employee> attendingList) {
        this.attendingList = attendingList;
    }

    public List<Employee> getAttendingList() {
        return attendingList;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
    }

    public List<Location> getLocation() {
        return location;
    }

    public void setStatus(STATUS status) {
        this.status = status == null ? null : status.getId();
    }

    public STATUS getStatus() {
        return status == null ? null : STATUS.fromId(status);
    }


}