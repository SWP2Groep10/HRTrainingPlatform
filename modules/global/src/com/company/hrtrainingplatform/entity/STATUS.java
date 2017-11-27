package com.company.hrtrainingplatform.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum STATUS implements EnumClass<String> {

    EXPIRED("10"),
    ONGOING("20"),
    PLANNED("30");

    private String id;

    STATUS(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static STATUS fromId(String id) {
        for (STATUS at : STATUS.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}