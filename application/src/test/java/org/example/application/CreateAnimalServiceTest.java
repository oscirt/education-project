package org.example.application;

import org.example.animalsstarter.config.AnimalsProperties;
import org.example.animalsstarter.entity.animals.Animal;
import org.example.animalsstarter.entity.animals.AnimalType;
import org.example.animalsstarter.service.interfaces.CreateAnimalService;
import org.example.application.config.AnimalsTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = AnimalsTestConfig.class)
@ActiveProfiles("test")
public class CreateAnimalServiceTest {

    @Autowired
    private AnimalsProperties animalsProperties;
    @Autowired
    private CreateAnimalService createAnimalService;

    @Test
    public void createRandomAnimalsTest() {
        Animal animal1 = createAnimalService.generateAnimal(AnimalType.CAT);
        Animal animal2 = createAnimalService.generateAnimal(AnimalType.CAT);
        Animal animal3 = createAnimalService.generateAnimal(AnimalType.DOG);

        assertNotSame(animal1, animal2);
        assertSame(animal1.getClass(), animal2.getClass());
        assertNotSame(animal1.getClass(), animal3.getClass());
    }

    @Test
    public void animalsRepositoryTest() {
        Animal cat = createAnimalService.generateAnimal(AnimalType.CAT);
        Animal dog = createAnimalService.generateAnimal(AnimalType.DOG);
        Animal shark = createAnimalService.generateAnimal(AnimalType.SHARK);
        Animal wolf = createAnimalService.generateAnimal(AnimalType.WOLF);

        assertTrue(animalsProperties.getCatNames().contains(cat.getName()));
        assertTrue(animalsProperties.getDogNames().contains(dog.getName()));
        assertTrue(animalsProperties.getSharkNames().contains(shark.getName()));
        assertTrue(animalsProperties.getWolfNames().contains(wolf.getName()));
    }
}
