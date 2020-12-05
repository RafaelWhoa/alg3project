package com.alg3.alg3project.services;

import java.util.List;
import java.util.Optional;

import com.alg3.alg3project.domain.RentalAgency;
import com.alg3.alg3project.dto.RentalAgencyDTO;
import com.alg3.alg3project.repository.RentalAgencyRepository;
import com.alg3.alg3project.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalAgencyService {
    
    @Autowired
    private RentalAgencyRepository rentalAgencyRepo;

    public List<RentalAgency> findAll() {
        return rentalAgencyRepo.findAll();
    }

    public RentalAgency findById(String id) {
        Optional<RentalAgency> obj = rentalAgencyRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }  

    public RentalAgency insert(RentalAgency rentalAgency) {
        return rentalAgencyRepo.insert(rentalAgency);
    }

    public void delete(String id) {
        findById(id);
        rentalAgencyRepo.deleteById(id);
    }

    public RentalAgency update(RentalAgency obj) {
        RentalAgency newObj = findById(obj.getId());
        updateData(newObj, obj);
        return rentalAgencyRepo.save(newObj);
    }

    private void updateData(RentalAgency newObj, RentalAgency obj) {
        newObj.setName(obj.getName());
        newObj.setAddress(obj.getAddress());
    }

    public RentalAgency fromDTO(RentalAgencyDTO objDto) {
        return new RentalAgency(objDto.getId(), objDto.getName(), objDto.getAddress());
    }
}
