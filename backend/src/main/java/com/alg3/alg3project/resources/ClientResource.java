package com.alg3.alg3project.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.alg3.alg3project.domain.Client;
import com.alg3.alg3project.dto.ClientDTO;
import com.alg3.alg3project.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
    
    @Autowired
    private ClientService clientService;

    @CrossOrigin
    @GetMapping(value = "/")
    public String text() {
        return "Essa frase aqui mesmo";
    }

    @CrossOrigin
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<ClientDTO>> findAll() {
        List<Client> list = clientService.findAll();
        List<ClientDTO> listDto = list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @CrossOrigin
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<ClientDTO> findById(@PathVariable String id) {
        Client obj = clientService.findById(id);
        return ResponseEntity.ok().body(new ClientDTO(obj));
    }

    @CrossOrigin
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody ClientDTO objDto) {
        Client obj = clientService.fromDTO(objDto);
        obj = clientService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCpf()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody ClientDTO objDto, @PathVariable String id) {
        Client obj = clientService.fromDTO(objDto);
        obj.setCpf(id);
        obj = clientService.update(obj);
        return ResponseEntity.noContent().build();
    }
}
