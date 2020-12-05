package com.alg3.alg3project.dto;

import java.io.Serializable;

import com.alg3.alg3project.domain.Client;

public class ClientDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String cpf;
    private String name;
    private String email;

    public ClientDTO() {
    }

    public ClientDTO(Client obj) {
        cpf = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
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

}
