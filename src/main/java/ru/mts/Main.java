package ru.mts;

import ru.mts.service.CreateAnimalServiceImpl;
import ru.mts.service.DefaultCreateAnimalService;
import ru.mts.service.interfaces.CreateAnimalService;

public class Main {

    public static void main(String[] args) {
        CreateAnimalService createAnimalService = new DefaultCreateAnimalService();
        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();

        createAnimalService.createAnimals();
        createAnimalServiceImpl.createAnimals();
        createAnimalServiceImpl.createAnimalsNumber(5);
        createAnimalServiceImpl.createAnimalsNumber(5L);
    }
}