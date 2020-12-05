package com.alg3.alg3project.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alg3.alg3project.domain.Client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
    
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Client>> findAll() {
        Client amanda = new Client(1, "Amanda", "amanda@gmail.com");
        Client rafael = new Client(2, "Rafael", "rafael@gmail.com");
        List<Client> list = new ArrayList<>();
        list.addAll(Arrays.asList(amanda, rafael));
        return ResponseEntity.ok().body(list);
    }
}
