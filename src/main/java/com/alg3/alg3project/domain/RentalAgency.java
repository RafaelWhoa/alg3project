package com.alg3.alg3project.domain;

import java.util.Objects;

public class RentalAgency {
    
    private String id;
    private String name;
    private String address;

    public RentalAgency() {
    }

    public RentalAgency(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RentalAgency)) {
            return false;
        }
        RentalAgency rentalAgency = (RentalAgency) o;
        return Objects.equals(id, rentalAgency.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
