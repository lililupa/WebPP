package com.example.webpp.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement (name = "root")
@XmlAccessorType( XmlAccessType.FIELD)
public class Root {
    @XmlElement (name ="operation")
    private List<String> operationList;

    public List<String> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<String> operationList) {
        this.operationList = operationList;
    }
}
