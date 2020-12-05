package com.alg3.alg3project.config;

import java.util.Arrays;

import com.alg3.alg3project.domain.Client;
import com.alg3.alg3project.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {
        
        clientRepository.deleteAll();

        Client maria = new Client(null, "Maria Brown", "maria@gmail.com");
        Client alex = new Client(null, "Alex Green", "alex@gmail.com");
        Client bob = new Client(null, "Bob Grey", "bob@gmail.com");
        clientRepository.saveAll(Arrays.asList(maria, alex, bob));

    }
    
}
