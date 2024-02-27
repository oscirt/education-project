package org.example.animalsstarter.repository;

import org.example.animalsstarter.entity.animals.Animal;
import org.example.animalsstarter.repository.interfaces.AnimalsRepository;
import org.example.animalsstarter.service.interfaces.CreateAnimalService;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalsRepositoryImpl implements AnimalsRepository {

    private Animal[] animals;

    private final CreateAnimalService createAnimalService;

    public AnimalsRepositoryImpl(CreateAnimalService createAnimalService) {
        this.createAnimalService = createAnimalService;
    }

    @PostConstruct
    public void initAnimalArray() {
        animals = createAnimalService.createAnimals();
    }

    /**
     * Ищет имена всех животных, которые родились в високосный год
     * @return массив имен животных
     */
    @Override
    public String[] findLeapYearNames() {
        int length = 0;
        for (Animal animal : animals) {
            if (animal.getBirthDate().isLeapYear()) {
                length++;
            }
        }
        String[] names = new String[length];
        for (int i = 0, j = 0; i < animals.length; i++) {
            if (animals[i].getBirthDate().isLeapYear()) {
                names[j++] = animals[i].getName();
            }
        }
        return names;
    }


    /**
     * Ищет всех животных, которые старше N лет
     * @param age граничный возраст
     * @return массив животных, старше N лет
     */
    @Override
    public Animal[] findOlderAnimal(int age) {
        int length = 0;
        for (Animal animal : animals) {
            if (LocalDate.now().getYear() - animal.getBirthDate().getYear() > age) {
                length++;
            }
        }
        Animal[] olderAnimals = new Animal[length];
        for (int i = 0, j = 0; i < animals.length; i++) {
            if (LocalDate.now().getYear() - animals[i].getBirthDate().getYear() > age) {
                olderAnimals[j++] = animals[i];
            }
        }
        return olderAnimals;
    }



    /**
     * Ищет всех повторяющихся животных и возвращает массив дубликатов
     * @return массив дубликатов
     */
    @Override
    public List<Animal> findDuplicate() {
        List<Animal> resultAnimals = new ArrayList<>();

        for (int i = 0; i < animals.length; i++) {
            for (int j = i + 1; j < animals.length; j++) {
                if (animals[i].equals(animals[j]) &&
                        i != j &&
                        !resultAnimals.contains(animals[i]) &&
                        !resultAnimals.contains(animals[j])) {
                    resultAnimals.add(animals[i]);
                }
            }
        }

        return resultAnimals;
    }

    /**
     * Выводит в консоль всех повторяющихся животных
     */
    @Override
    public void printDuplicate() {
        List<Animal> duplicateAnimals = findDuplicate();
        duplicateAnimals.forEach(animal -> System.out.printf("Duplicate animal: %s\n", animal));
    }
}
