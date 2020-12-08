package com.alg3.alg3project.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.alg3.alg3project.domain.Vehicle;
import com.alg3.alg3project.dto.VehicleDTO;
import com.alg3.alg3project.services.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/vehicles")
public class VehicleResource {
    
    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<VehicleDTO>> findAll() {
        List<Vehicle> list = vehicleService.findAll();
        List<VehicleDTO> listDto = list.stream().map(x -> new VehicleDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<VehicleDTO> findById(@PathVariable String id) {
        Vehicle obj = vehicleService.findById(id);
        return ResponseEntity.ok().body(new VehicleDTO(obj));
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody VehicleDTO objDto) {
        Vehicle obj = vehicleService.fromDTO(objDto);
        obj = vehicleService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        vehicleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody VehicleDTO objDto, @PathVariable String id) {
        Vehicle obj = vehicleService.fromDTO(objDto);
        obj.setId(id);
        obj = vehicleService.update(obj);
        return ResponseEntity.noContent().build();
    }
}
