package com.thtek.irctcautobooker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PackInfo")
public class PackDetails {
    @Id
    String id;
    String phNo;
    String dateTime;
    String validity;
    String expiryTimeStamp;
    int packNumber;
    String status;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

}
