package com.alg3.alg3project.dto;

import java.io.Serializable;

import com.alg3.alg3project.domain.Vehicle;

public class VehicleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String manufacturer;
    private String model;
    private RentalAgencyDTO rentalAgency;

    public VehicleDTO() {
    }

    public VehicleDTO(Vehicle obj) {
        id = obj.getId();
        manufacturer = obj.getManufacturer();
        model = obj.getModel();
        rentalAgency = obj.getRentalAgency();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setName(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public RentalAgencyDTO getRentalAgency() {
        return rentalAgency;
    }

    public void setRentalAgency(RentalAgencyDTO rentalAgency) {
        this.rentalAgency = rentalAgency;
    }

}
