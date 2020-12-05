package com.alg3.alg3project.services;

import java.util.List;
import java.util.Optional;

import com.alg3.alg3project.domain.Vehicle;
import com.alg3.alg3project.dto.VehicleDTO;
import com.alg3.alg3project.repository.VehicleRepository;
import com.alg3.alg3project.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    
    @Autowired
    private VehicleRepository vehicleRepo;

    public List<Vehicle> findAll() {
        return vehicleRepo.findAll();
    }

    public Vehicle findById(String id) {
        Optional<Vehicle> obj = vehicleRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }  

    public Vehicle insert(Vehicle vehicle) {
        return vehicleRepo.insert(vehicle);
    }

    public void delete(String id) {
        findById(id);
        vehicleRepo.deleteById(id);
    }

    public Vehicle update(Vehicle obj) {
        Vehicle newObj = findById(obj.getId());
        updateData(newObj, obj);
        return vehicleRepo.save(newObj);
    }

    private void updateData(Vehicle newObj, Vehicle obj) {
        newObj.setManufacturer(obj.getManufacturer());
        newObj.setModel(obj.getModel());
    }

    public Vehicle fromDTO(VehicleDTO objDto) {
        return new Vehicle(objDto.getId(), objDto.getLicensePlate(), objDto.getManufacturer(), objDto.getModel(),
         objDto.getCategory(), objDto.getPricePerHour(), objDto.getPricePerDay(), objDto.getRentalAgency(), objDto.getRentedBy());
    }
}
