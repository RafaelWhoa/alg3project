package com.alg3.alg3project.domain;

import java.io.Serializable;
import java.util.Objects;

import com.alg3.alg3project.dto.RentalAgencyDTO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String manufacturer;
    private String model;
    private RentalAgencyDTO rentalAgency;

    public Vehicle() {
    }

    public Vehicle(String id, String Manufacturer, String Model, RentalAgencyDTO rentalAgency) {
        this.id = id;
        this.manufacturer = Manufacturer;
        this.model = Model;
        this.rentalAgency = rentalAgency;
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
