package com.alg3.alg3project.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.alg3.alg3project.domain.Client;
import com.alg3.alg3project.dto.ClientDTO;
import com.alg3.alg3project.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
    
    @Autowired
    private ClientService clientService;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<ClientDTO>> findAll() {
        List<Client> list = clientService.findAll();
        List<ClientDTO> listDto = list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<ClientDTO> findById(@PathVariable String id) {
        Client obj = clientService.findById(id);
        return ResponseEntity.ok().body(new ClientDTO(obj));
    }
}
