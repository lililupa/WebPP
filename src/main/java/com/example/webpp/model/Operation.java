package com.example.webpp.model;

import com.sun.xml.txw2.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlValue;
@XmlAccessorType ( XmlAccessType.FIELD)
public class Operation {
    @XmlValue
    private String operation;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
