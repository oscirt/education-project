package org.example.application.scheduler;

import org.example.animalsstarter.exception.checked.WrongListArgumentException;
import org.example.animalsstarter.exception.unchecked.WrongAgeArgumentException;
import org.example.animalsstarter.repository.interfaces.AnimalsRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AnimalsRepositoryScheduler {

    private final AnimalsRepository animalsRepository;

    public AnimalsRepositoryScheduler(AnimalsRepository animalsRepository) {
        this.animalsRepository = animalsRepository;
    }

    @Scheduled(fixedRate = 60_000L)
    public void runAllAnimalsRepositoryMethods() {
        try {
            System.out.printf("findLeapYearNames: \n%s\n\n", animalsRepository.findLeapYearNames());
            System.out.printf("findOlderAnimal(5): \n%s\n\n", animalsRepository.findOlderAnimal(5));
            System.out.printf("findDuplicate: \n%s\n\n", animalsRepository.findDuplicate());
            System.out.println("printDuplicate: ");
            animalsRepository.printDuplicate();
            System.out.println();
            animalsRepository.findAverageAge();
            System.out.println();
            System.out.printf("findOldAndExpensive: \n%s\n\n", animalsRepository.findOldAndExpensive());
            System.out.printf("findMinCostAnimals: \n%s\n\n", animalsRepository.findMinCostAnimals());
        } catch (WrongAgeArgumentException e) {
            System.out.printf("Wrong age exception: %s\n", e.getMessage());
        } catch (WrongListArgumentException e) {
            System.out.printf("Wrong list size exception: %s\n", e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
