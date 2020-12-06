package com.alg3.alg3project.domain;

import java.util.Date;
import java.util.Objects;


import com.alg3.alg3project.dto.VehicleDTO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Client {
    

    @Id
    private String cpf;


    private String name;
    private String email;
    private Date birthDate;
    private String address;
    private String phone;
    private VehicleDTO vehicleRented;

    public Client() {
    }

    public Client(String cpf, String name, String email, Date birthDate, String address, String phone, VehicleDTO vehicleRented) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.vehicleRented = vehicleRented;
    }
    
    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public void setVehicleRented(VehicleDTO carRented) {
        this.vehicleRented = carRented;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Client)) {
            return false;
        }
        Client client = (Client) o;
        return Objects.equals(cpf, client.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return "{" +
            " cpf='" + getCpf() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            ", address='" + getAddress() + "'" +
            ", phone='" + getPhone() + "'" +
            ", vehicleRented='" + getVehicleRented() + "'" +
            "}";
    }

}
