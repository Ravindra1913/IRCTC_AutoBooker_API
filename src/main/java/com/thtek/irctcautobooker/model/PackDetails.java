package com.thtek.irctcautobooker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "PackInfo")
public class PackDetails {

    @Id
    String id;

    String phNo;
    Date dateTime;
    int validity;
    Date expiryTimeStamp;
    int packNumber;
    boolean isActive;

    public PackDetails() {
    }

    public PackDetails(String id, String phNo, Date dateTime, int validity, Date expiryTimeStamp, int packNumber, boolean isActive) {
        this.id = id;
        this.phNo = phNo;
        this.dateTime = dateTime;
        this.validity = validity;
        this.expiryTimeStamp = expiryTimeStamp;
        this.packNumber = packNumber;
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

}
