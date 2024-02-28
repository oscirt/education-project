package org.example.application.config;

import org.example.animalsstarter.factory.AnimalFactory;
import org.example.animalsstarter.service.CreateAnimalServiceImpl;
import org.example.animalsstarter.service.interfaces.CreateAnimalService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class AnimalsTestConfig {

    @Bean
    public CreateAnimalService createAnimalService(AnimalFactory animalFactory) {
        return new CreateAnimalServiceImpl(animalFactory);
    }
}
