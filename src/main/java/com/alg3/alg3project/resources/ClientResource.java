package com.alg3.alg3project.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alg3.alg3project.domain.Client;
import com.alg3.alg3project.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
    
    @Autowired
    private ClientService clientService;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Client>> findAll() {
        List<Client> list = clientService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
