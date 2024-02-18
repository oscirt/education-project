package org.example.application.scheduler;

import org.example.animalsstarter.repository.interfaces.AnimalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AnimalsRepositoryScheduler {

    private final AnimalsRepository animalsRepository;

    public AnimalsRepositoryScheduler(@Autowired AnimalsRepository animalsRepository) {
        this.animalsRepository = animalsRepository;
    }

    @Scheduled(fixedRate = 60_000L)
    public void runAllAnimalsRepositoryMethods() {
        System.out.printf("findLeapYearNames: \n%s\n\n", Arrays.toString(animalsRepository.findLeapYearNames()));
        System.out.printf("findOlderAnimal(5): \n%s\n\n", Arrays.toString(animalsRepository.findOlderAnimal(5)));
        System.out.printf("findDuplicate: \n%s\n\n", animalsRepository.findDuplicate());
        System.out.println("printDuplicate: ");
        animalsRepository.printDuplicate();
    }
}
