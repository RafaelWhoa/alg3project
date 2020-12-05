package com.alg3.alg3project.services;

import java.util.List;
import java.util.Optional;

import com.alg3.alg3project.domain.Client;
import com.alg3.alg3project.dto.ClientDTO;
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

    public Client insert(Client client) {
        return clientRepo.insert(client);
    }

    public void delete(String id) {
        findById(id);
        clientRepo.deleteById(id);
    }

    public Client update(Client obj) {
        Client newObj = findById(obj.getId());
        updateData(newObj, obj);
        return clientRepo.save(newObj);
    }

    private void updateData(Client newObj, Client obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public Client fromDTO(ClientDTO objDto) {
        return new Client(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
