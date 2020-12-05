package com.alg3.alg3project.domain;

import java.io.Serializable;
import java.util.Objects;

public class Vehicle implements Serializable {
 
    private static final long serialVersionUID = 1L;

    private String id;
    private String Manufacturer;
    private String Model;

    public Vehicle() {
    }

    public Vehicle(String id, String Manufacturer, String Model) {
        this.id = id;
        this.Manufacturer = Manufacturer;
        this.Model = Model;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufacturer() {
        return this.Manufacturer;
    }

    public void setManufacturer(String Manufacturer) {
        this.Manufacturer = Manufacturer;
    }

    public String getModel() {
        return this.Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
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
