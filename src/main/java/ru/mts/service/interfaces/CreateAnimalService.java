package ru.mts.service.interfaces;

import ru.mts.factory.AnimalFactory;
import ru.mts.entity.animals.*;

import java.util.Random;

public interface CreateAnimalService {

    /**
     * Генерирует животное случайного типа
     * @return созданное животное
     */
    default Animal generateRandomAnimal() {
        Random random = new Random();
        return AnimalFactory.createAnimal(random.nextInt(4));
    }

    /**
     * Создает 10 животных случайного типа
     * @return 10 животных случайного типа
     */
    default Animal[] createAnimals() {
        int i = 0;
        Animal[] animals = new Animal[10];
        while (i < 10) {
            animals[i] = generateRandomAnimal();
            i++;
        }
        return animals;
    }
}
