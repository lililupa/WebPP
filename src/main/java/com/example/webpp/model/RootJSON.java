package com.example.webpp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RootJSON {
@JsonProperty ("operation")
    private List<String> operation;

    public List<String> getOperation() {
        return operation;
    }

    public void setOperation(List<String> operation) {
        this.operation = operation;
    }
    @Override
    public String toString() {
        return "RootJSON{" +
                "operation=" + operation +
                '}';
    }
}
