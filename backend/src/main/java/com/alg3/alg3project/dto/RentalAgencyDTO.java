package com.alg3.alg3project.dto;

import java.io.Serializable;

import com.alg3.alg3project.domain.RentalAgency;

public class RentalAgencyDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String address;

    public RentalAgencyDTO() {
    }

    public RentalAgencyDTO(RentalAgency obj) {
        id= obj.getId();
        name = obj.getName();
        address = obj.getAddress();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
}
