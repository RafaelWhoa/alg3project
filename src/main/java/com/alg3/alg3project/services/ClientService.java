package com.alg3.alg3project.services;

import java.util.List;
import java.util.Optional;

import com.alg3.alg3project.domain.Client;
import com.alg3.alg3project.repository.ClientRepository;
import com.alg3.alg3project.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepo;

    public List<Client> findAll() {
        return clientRepo.findAll();
    }

    public Client findById(String id) {
        Optional<Client> obj = clientRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }  
}
