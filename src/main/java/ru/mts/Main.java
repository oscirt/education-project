package ru.mts;

import ru.mts.entity.animals.Animal;
import ru.mts.service.CreateAnimalServiceImpl;
import ru.mts.service.SearchServiceImpl;
import ru.mts.service.interfaces.SearchService;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        CreateAnimalServiceImpl createAnimalService = new CreateAnimalServiceImpl();
        SearchService searchService = new SearchServiceImpl();
        Animal[] animals = createAnimalService.createAnimals();

        System.out.println("Leap year names:");
        System.out.println(Arrays.toString(searchService.findLeapYearNames(animals)));
        System.out.println();

        System.out.println("Older animal:");
        System.out.println(Arrays.toString(searchService.findOlderAnimal(animals, 10)));
        System.out.println();

        System.out.println("Duplicate animals:");
        searchService.printDuplicate(animals);
    }
}