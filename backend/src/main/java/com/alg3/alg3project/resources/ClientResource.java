package com.alg3.alg3project.resources;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.alg3.alg3project.domain.Client;
import com.alg3.alg3project.domain.Vehicle;
import com.alg3.alg3project.dto.ClientDTO;
import com.alg3.alg3project.repository.ClientRepository;
import com.alg3.alg3project.services.ClientService;
import com.alg3.alg3project.services.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/clients")
public class ClientResource {
    
    @Autowired
    private ClientService clientService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<ClientDTO>> findAll() {
        List<Client> list = clientService.findAll();
        List<ClientDTO> listDto = list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok()./*header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept").*/body(listDto);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<ClientDTO> findById(@PathVariable String id) {
        Client obj = clientService.findById(id);
        return ResponseEntity.ok().body(new ClientDTO(obj));
    }

    @RequestMapping(value="/{id}", method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody ClientDTO objDto) {
        Client obj = clientService.fromDTO(objDto);
        obj = clientService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCpf()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/alugar/cadastro", method=RequestMethod.POST)
    public ResponseEntity<ClientDTO> cadastro(@PathVariable String id, @RequestBody ClientDTO client, @RequestParam(value="id", required=true) String id2) {
        Vehicle obj = vehicleService.findById(id2);
        if (obj == null) {
            return ResponseEntity.notFound().build();
        }
        else{
            Client obj2 = clientService.fromDTO(client);
            obj2 = clientService.insert(obj2);
            clientRepository.saveAll(Arrays.asList(obj2));
            obj.setRentedBy(new ClientDTO(obj2));
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/alugar/cadastro").buildAndExpand(obj2.getCpf()).toUri();
            return ResponseEntity.created(uri).build();
        }
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody ClientDTO objDto, @PathVariable String id) {
        Client obj = clientService.fromDTO(objDto);
        obj.setCpf(id);
        obj = clientService.update(obj);
        return ResponseEntity.noContent().build();
    }

}
