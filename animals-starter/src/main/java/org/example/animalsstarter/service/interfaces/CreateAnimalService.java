package org.example.animalsstarter.service.interfaces;

import org.example.animalsstarter.entity.animals.Animal;
import org.example.animalsstarter.entity.animals.AnimalType;

public interface CreateAnimalService {



    /**
     * Генерирует животное случайного типа
     * @return созданное животное
     */
    Animal generateRandomAnimal();

    Animal generateAnimal(AnimalType type);

    /**
     * Создает 10 животных случайного типа
     * @return 10 животных случайного типа
     */
    Animal[] createAnimals();
}
