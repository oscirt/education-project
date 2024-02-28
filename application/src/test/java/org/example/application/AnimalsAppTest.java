package org.example.application;

import org.example.animalsstarter.config.AnimalsProperties;
import org.example.animalsstarter.entity.animals.Animal;
import org.example.animalsstarter.repository.interfaces.AnimalsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Map;
import java.util.Map.Entry;

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
        Map<Animal, Integer> animals = animalsRepository.findOlderAnimal(5);
        int currentYear = LocalDate.now().getYear();
        for (Entry<Animal, Integer> entry : animals.entrySet()) {
            assertTrue(currentYear - entry.getKey().getBirthDate().getYear() >= 5);
            assertTrue(entry.getValue() >= 5);
        }
    }

    @Test
    public void findLeapYearNamesTest() {
        Map<String, LocalDate> names = animalsRepository.findLeapYearNames();
        for (String name : names.keySet()) {
            String animalName = name.substring(name.indexOf(' '));
            assertTrue(
                    animalsProperties.getCatNames().contains(animalName) ||
                            animalsProperties.getDogNames().contains(animalName) ||
                            animalsProperties.getSharkNames().contains(animalName) ||
                            animalsProperties.getWolfNames().contains(animalName)
            );
        }
    }
}
