package com.alg3.alg3project.dto;

import java.io.Serializable;

import com.alg3.alg3project.domain.Vehicle;

public class VehicleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String licensePlate;
    private String manufacturer;
    private String model;
    private String category;
    private Double pricePerHour;
    private Double pricePerDay;
    private RentalAgencyDTO rentalAgency;
    private ClientDTO rentedBy;

    public VehicleDTO() {
    }

    public VehicleDTO(Vehicle obj) {
        id = obj.getId();
        licensePlate = obj.getLicensePlate();
        manufacturer = obj.getManufacturer();
        model = obj.getModel();
        category = obj.getCategory();
        rentalAgency = obj.getRentalAgency();
        pricePerHour = obj.getPricePerHour();
        pricePerDay = obj.getPricePerDay();
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

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPricePerHour() {
        return this.pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public ClientDTO getRentedBy() {
        return this.rentedBy;
    }

    public void setRentedBy(ClientDTO rentedBy) {
        this.rentedBy = rentedBy;
    }

}
