package ru.mts;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mts.config.ApplicationConfig;
import ru.mts.repository.interfaces.AnimalsRepository;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        AnimalsRepository animalsRepository = applicationContext.getBean(AnimalsRepository.class);

        System.out.printf("findLeapYearNames: \n%s\n\n", Arrays.toString(animalsRepository.findLeapYearNames()));
        System.out.printf("findOlderAnimal(5): \n%s\n\n", Arrays.toString(animalsRepository.findOlderAnimal(5)));
        System.out.printf("findDuplicate: \n%s\n\n", animalsRepository.findDuplicate());
        animalsRepository.printDuplicate();
    }
}