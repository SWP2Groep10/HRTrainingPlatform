package com.company.hrtrainingplatform.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|locationName")
@Table(name = "HRTRAININGPLATFORM_LOCATION")
@Entity(name = "hrtrainingplatform$Location")
public class Location extends StandardEntity {
    private static final long serialVersionUID = 8506275702325742061L;

    @OnDelete(DeletePolicy.UNLINK)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ADDRESS_ID")
    @NotNull(message = "This value can not be null")
    protected Address address;

    @NotNull(message = "This value can not be null")
    @Column(name = "LOCATION_NAME", nullable = false, unique = true, length = 100)
    protected String locationName;

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationName() {
        return locationName;
    }


}