package com.dunnwr.cleantaskmanager.domain;

public enum Status {

    PENDING("pending"), COMPLETED("completed");

    private final String status;

    Status(String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }
}
