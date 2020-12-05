package com.alg3.alg3project.domain;

import java.io.Serializable;
import java.util.Objects;

import com.alg3.alg3project.dto.ClientDTO;
import com.alg3.alg3project.dto.RentalAgencyDTO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String licensePlate;
    private String manufacturer;
    private String model;
    private String category;
    private Double pricePerHour;
    private Double pricePerDay;
    private RentalAgencyDTO rentalAgency;
    private ClientDTO rentedBy;

    public Vehicle() {
    }

    public Vehicle(String id, String licensePlate, String manufacturer, String model, String category, Double pricePerHour, Double pricePerDay, RentalAgencyDTO rentalAgency, ClientDTO rentedBy) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.manufacturer = manufacturer;
        this.model = model;
        this.category = category;
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.rentalAgency = rentalAgency;
        this.rentedBy = rentedBy;
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

    public void setManufacturer(String Manufacturer) {
        this.manufacturer = Manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String Model) {
        this.model = Model;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vehicle)) {
            return false;
        }
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
