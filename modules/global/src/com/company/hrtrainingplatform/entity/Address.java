package com.company.hrtrainingplatform.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s %s %s %s|street,city,country,number")
@Table(name = "HRTRAININGPLATFORM_ADDRESS")
@Entity(name = "hrtrainingplatform$Address")
public class Address extends StandardEntity {
    private static final long serialVersionUID = -4607488382137891335L;

    @NotNull(message = "This value can not be null")
    @Column(name = "COUNTRY", nullable = false, length = 100)
    protected String country;

    @NotNull(message = "This value can not be null")
    @Column(name = "CITY", nullable = false, length = 100)
    protected String city;

    @NotNull(message = "This value can not be null")
    @Column(name = "POSTALCODE", nullable = false)
    protected String postalcode;

    @NotNull(message = "This value can not be null")
    @Column(name = "STREET", nullable = false, length = 100)
    protected String street;

    @NotNull(message = "This value can not be null")
    @Column(name = "NUMBER_", nullable = false)
    protected Integer number;
    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }



    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }



    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }


}