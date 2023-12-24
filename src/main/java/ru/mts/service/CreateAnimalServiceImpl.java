package ru.mts.service;

import ru.mts.service.interfaces.CreateAnimalService;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    public void createAnimals(int number) {
        System.out.println("\n*-----CreateAnimalServiceImpl int number-----*");
        for (int i = 0; i < number; i++) {
            generateRandomAnimal();
        }
    }

    @Override
    public void createAnimals() {
        System.out.println("\n*-----CreateAnimalServiceImpl-----*");
        int i = 0;
        do {
            generateRandomAnimal();
        } while (++i < 10);
    }
}
