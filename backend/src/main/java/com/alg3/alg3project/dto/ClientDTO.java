package com.alg3.alg3project.dto;

import java.io.Serializable;
import java.util.Date;

import com.alg3.alg3project.domain.Client;

public class ClientDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String cpf;
    private String name;
    private String email;
    private Date birthDate;
    private String address;
    private String phone;
    private VehicleDTO vehicleRented;

    public ClientDTO() {
    }

    public ClientDTO(Client obj) {
        cpf = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
        birthDate = obj.getBirthDate();
        address = obj.getAddress();
        phone = obj.getPhone();
        vehicleRented = obj.getVehicleRented();
    }

    public String getId() {
        return this.cpf;
    }

    public void setId(String id) {
        this.cpf = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public VehicleDTO getVehicleRented() {
        return this.vehicleRented;
    }

    public void setVehicleRented(VehicleDTO vehicleRented) {
        this.vehicleRented = vehicleRented;
    }

}
