package com.alg3.alg3project.config;

import java.util.Arrays;

import com.alg3.alg3project.domain.Client;
import com.alg3.alg3project.domain.RentalAgency;
import com.alg3.alg3project.domain.Vehicle;
import com.alg3.alg3project.dto.RentalAgencyDTO;
import com.alg3.alg3project.repository.ClientRepository;
import com.alg3.alg3project.repository.RentalAgencyRepository;
import com.alg3.alg3project.repository.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private RentalAgencyRepository rentalAgencyRepository;

    @Override
    public void run(String... args) throws Exception {
        
        clientRepository.deleteAll();

        Client maria = new Client(null, "Maria Brown", "maria@gmail.com");
        Client alex = new Client(null, "Alex Green", "alex@gmail.com");
        Client bob = new Client(null, "Bob Grey", "bob@gmail.com");
        clientRepository.saveAll(Arrays.asList(maria, alex, bob));

        rentalAgencyRepository.deleteAll();

        RentalAgency ra1 = new RentalAgency(null, "Rental-1", "Rua 1");
        rentalAgencyRepository.saveAll(Arrays.asList(ra1));

        vehicleRepository.deleteAll();

        Vehicle car1 = new Vehicle(null, "Chevrolet", "Onix", new RentalAgencyDTO(ra1));
        vehicleRepository.saveAll(Arrays.asList(car1));

        

    }
    
}
