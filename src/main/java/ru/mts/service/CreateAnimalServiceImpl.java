package ru.mts.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.mts.entity.animals.Animal;
import ru.mts.entity.animals.AnimalType;
import ru.mts.service.interfaces.CreateAnimalService;

import java.util.Random;

@Service
@Scope("prototype")
public class CreateAnimalServiceImpl implements CreateAnimalService {

    private AnimalType animalType;

    /**
     * Создает N животных случайного типа
     * @param number количество создаваемых животных
     * @return массив животных
     */
    public Animal[] createAnimals(int number) {
        Animal[] animals = new Animal[number];
        for (int i = 0; i < number; i++) {
            animals[i] = generateRandomAnimal();
        }
        return animals;
    }

    /**
     * Создает 10 животных случайного типа
     * @return 10 животных случайного типа
     */
    @Override
    public Animal[] createAnimals() {
        int i = 0;
        Animal[] animals = new Animal[10];
        do {
            animals[i] = generateAnimal(animalType);
        } while (++i < 10);
        return animals;
    }

    public void initAnimalType() {
        switch (new Random().nextInt() % 4) {
            case 0:
                animalType = AnimalType.CAT;
                break;
            case 1:
                animalType = AnimalType.DOG;
                break;
            case 2:
                animalType = AnimalType.WOLF;
                break;
            case 3:
                animalType = AnimalType.SHARK;
                break;
        }
    }
}
