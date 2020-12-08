package com.alg3.alg3project.config;

import java.util.Arrays;
import java.util.Date;

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

        Client maria = new Client(null, "Maria Brown", "maria@gmail.com", new Date(), "Rua 2", "555-555-555", null);
        Client alex = new Client(null, "Alex Green", "alex@gmail.com", new Date(), "Rua 2", "555-555-555", null);
        Client bob = new Client(null, "Bob Grey", "bob@gmail.com", new Date(), "Rua 2", "555-555-555", null);
        clientRepository.saveAll(Arrays.asList(maria, alex, bob));

        rentalAgencyRepository.deleteAll();

        RentalAgency ra1 = new RentalAgency(null, "Rental-1", "Rua 1");
        rentalAgencyRepository.saveAll(Arrays.asList(ra1));
<<<<<<< HEAD
=======

        vehicleRepository.deleteAll();

        Vehicle car1 = new Vehicle(null, "KKK-5555", "Chevrolet", "Onix", "Compact", 100.00, 200.00, new RentalAgencyDTO(ra1), null);
        Vehicle car2 = new Vehicle(null, "KKK-5556", "Ford", "Ka", "Compact", 100.00, 200.00, new RentalAgencyDTO(ra1), null);
        Vehicle car3 = new Vehicle(null, "KKK-5557", "Nissan", "Kicks", "SUV", 100.00, 200.00, new RentalAgencyDTO(ra1), null);
        Vehicle car4 = new Vehicle(null, "KKK-5558", "Volvo", "XC40", "SUV", 100.00, 200.00, new RentalAgencyDTO(ra1), null);
        Vehicle car5 = new Vehicle(null, "KKK-5559", "Toyota", "Corolla", "Sedan", 100.00, 200.00, new RentalAgencyDTO(ra1), null);
        vehicleRepository.saveAll(Arrays.asList(car1, car2, car3, car4, car5));

>>>>>>> e03c0c1785ce47bb8779f6f5f8e9d72d0590eb62
        

    }
    
}
