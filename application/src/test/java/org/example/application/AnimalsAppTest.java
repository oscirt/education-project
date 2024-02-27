package org.example.application;

import org.example.animalsstarter.config.AnimalsProperties;
import org.example.animalsstarter.entity.animals.Animal;
import org.example.animalsstarter.repository.interfaces.AnimalsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class AnimalsAppTest {

    @Autowired
    private AnimalsRepository animalsRepository;
    @Autowired
    private AnimalsProperties animalsProperties;

    @Test
    public void findOlderAnimalTest() {
        Animal[] animals = animalsRepository.findOlderAnimal(5);
        int currentYear = LocalDate.now().getYear();
        for (Animal animal : animals) {
            assertTrue(currentYear - animal.getBirthDate().getYear() >= 5);
        }
    }

    @Test
    public void findLeapYearNamesTest() {
        String[] names = animalsRepository.findLeapYearNames();
        for (String name : names) {
            assertTrue(
                    animalsProperties.getCatNames().contains(name) ||
                    animalsProperties.getDogNames().contains(name) ||
                    animalsProperties.getSharkNames().contains(name) ||
                    animalsProperties.getWolfNames().contains(name)
            );
        }
    }
}
