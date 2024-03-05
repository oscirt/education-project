package org.example.application;

import org.example.animalsstarter.config.AnimalsProperties;
import org.example.animalsstarter.entity.animals.*;
import org.example.animalsstarter.repository.interfaces.AnimalsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
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
            String animalName = name.substring(name.indexOf(' ') + 1);
            assertTrue(
                    animalsProperties.getCatNames().contains(animalName) ||
                            animalsProperties.getDogNames().contains(animalName) ||
                            animalsProperties.getSharkNames().contains(animalName) ||
                            animalsProperties.getWolfNames().contains(animalName)
            );
        }
    }


    @Test
    public void findAverageAge() {
        List<Animal> animalList = List.of(
                new Dog("1", "1", BigDecimal.valueOf(1), "1", LocalDate.of(2020, 10, 10)),
                new Shark("1", "1", BigDecimal.valueOf(1), "1", LocalDate.of(2010, 10, 10))
        );
        animalsRepository.findAverageAge(animalList);
    }

    @Test
    public void findOldAndExpensive1() {
        List<Animal> animalList = List.of(
                new Dog("Dog", "dog", BigDecimal.valueOf(20), "character",
                        LocalDate.of(2000, 12, 13)),
                new Cat("Cat", "dog", BigDecimal.valueOf(100), "character",
                        LocalDate.of(2021, 3, 4)),
                new Wolf("Wolf", "wolf", BigDecimal.valueOf(1000), "character",
                        LocalDate.of(2003, 6, 5)),
                new Shark("Shark", "shark", BigDecimal.valueOf(10000), "character",
                        LocalDate.of(2020, 1, 3))
        );

        Assertions.assertEquals(List.of(), animalsRepository.findOldAndExpensive(animalList));
    }

    @Test
    public void findOldAndExpensive2() {
        List<Animal> animalList = List.of(
                new Dog("Dog", "dog", BigDecimal.valueOf(2000), "character",
                        LocalDate.of(2020, 12, 13)),
                new Cat("Cat", "dog", BigDecimal.valueOf(1001), "character",
                        LocalDate.of(2003, 3, 4)),
                new Wolf("Wolf", "wolf", BigDecimal.valueOf(100), "character",
                        LocalDate.of(2003, 6, 5)),
                new Shark("Shark", "shark", BigDecimal.valueOf(4000), "character",
                        LocalDate.of(2003, 1, 3))
        );

        Assertions.assertEquals(
                List.of(new Shark("Shark", "shark", BigDecimal.valueOf(4000), "character",
                        LocalDate.of(2003, 1, 3))
                ), animalsRepository.findOldAndExpensive(animalList));
    }

    @Test
    public void findOldAndExpensive3() {
        List<Animal> animalList = List.of(
                new Dog("Dog", "dog", BigDecimal.valueOf(2000), "character",
                        LocalDate.of(2002, 12, 13)),
                new Cat("Cat", "dog", BigDecimal.valueOf(1001), "character",
                        LocalDate.of(2003, 3, 4)),
                new Wolf("Wolf", "wolf", BigDecimal.valueOf(100), "character",
                        LocalDate.of(2003, 6, 5)),
                new Shark("Shark", "shark", BigDecimal.valueOf(4000), "character",
                        LocalDate.of(2003, 1, 3))
        );

        Assertions.assertEquals(
                List.of(
                        new Dog("Dog", "dog", BigDecimal.valueOf(2000), "character",
                                LocalDate.of(2002, 12, 13)),
                        new Shark("Shark", "shark", BigDecimal.valueOf(4000), "character",
                                LocalDate.of(2003, 1, 3))
                ), animalsRepository.findOldAndExpensive(animalList));
    }

    @Test
    public void findMinConstAnimals() {
        List<Animal> animalList = List.of(
                new Dog("Dog", "dog", BigDecimal.valueOf(2000), "character",
                        LocalDate.of(2002, 12, 13)),
                new Cat("Cat", "cat", BigDecimal.valueOf(1001), "character",
                        LocalDate.of(2003, 3, 4)),
                new Wolf("Wolf", "wolf", BigDecimal.valueOf(100), "character",
                        LocalDate.of(2003, 6, 5)),
                new Shark("Shark", "shark", BigDecimal.valueOf(4000), "character",
                        LocalDate.of(2003, 1, 3))
        );

        Assertions.assertEquals(List.of("shark", "dog", "cat"), animalsRepository.findMinConstAnimals(animalList));
    }
}
