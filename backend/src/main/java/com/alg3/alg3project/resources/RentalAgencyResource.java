package com.alg3.alg3project.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.alg3.alg3project.domain.RentalAgency;
import com.alg3.alg3project.dto.RentalAgencyDTO;
import com.alg3.alg3project.services.RentalAgencyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/rental_agencies")
public class RentalAgencyResource {
    
    @Autowired
    private RentalAgencyService rentalAgencyService;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<RentalAgencyDTO>> findAll() {
        List<RentalAgency> list = rentalAgencyService.findAll();
        List<RentalAgencyDTO> listDto = list.stream().map(x -> new RentalAgencyDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<RentalAgencyDTO> findById(@PathVariable String id) {
        RentalAgency obj = rentalAgencyService.findById(id);
        return ResponseEntity.ok().body(new RentalAgencyDTO(obj));
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody RentalAgencyDTO objDto) {
        RentalAgency obj = rentalAgencyService.fromDTO(objDto);
        obj = rentalAgencyService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        rentalAgencyService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody RentalAgencyDTO objDto, @PathVariable String id) {
        RentalAgency obj = rentalAgencyService.fromDTO(objDto);
        obj.setId(id);
        obj = rentalAgencyService.update(obj);
        return ResponseEntity.noContent().build();
    }
}
