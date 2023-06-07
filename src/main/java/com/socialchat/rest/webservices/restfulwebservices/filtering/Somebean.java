package com.socialchat.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.minidev.json.annotate.JsonIgnore;

//@JsonIgnoreProperties("field2")
// static filtering

@JsonFilter("Somebean Filter")
public class Somebean {

    private String fieldname1;

    @JsonIgnore
    private String fieldname2;
    private String fieldname3;
    public Somebean(String fieldname1, String fieldname2, String fieldname3) {
        this.fieldname1 = fieldname1;
        this.fieldname2 = fieldname2;
        this.fieldname3 = fieldname3;
    }

    public String getFieldname1() {
        return fieldname1;
    }

    public void setFieldname1(String fieldname1) {
        this.fieldname1 = fieldname1;
    }

    public String getFieldname2() {
        return fieldname2;
    }

    public void setFieldname2(String fieldname2) {
        this.fieldname2 = fieldname2;
    }

    public String getFieldname3() {
        return fieldname3;
    }

    @Override
    public String toString() {
        return "Somebean{" +
                "fieldname1='" + fieldname1 + '\'' +
                ", fieldname2='" + fieldname2 + '\'' +
                ", fieldname3='" + fieldname3 + '\'' +
                '}';
    }

    public void setFieldname3(String fieldname3) {
        this.fieldname3 = fieldname3;
    }



}
