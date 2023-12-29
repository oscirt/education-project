package ru.mts.service;

import ru.mts.model.animals.Animal;
import ru.mts.service.interfaces.CreateAnimalService;

public class CreateAnimalServiceImpl implements CreateAnimalService {

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
            animals[i] = generateRandomAnimal();
        } while (++i < 10);
        return animals;
    }
}
