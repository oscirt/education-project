package org.example.animalsstarter.repository;

import org.example.animalsstarter.entity.animals.Animal;
import org.example.animalsstarter.repository.interfaces.AnimalsRepository;
import org.example.animalsstarter.service.interfaces.CreateAnimalService;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;

@Repository
public class AnimalsRepositoryImpl implements AnimalsRepository {

    private Map<String, List<Animal>> animals;

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
     * @return Map с ключом, являющимся строкой с типом животного и его именем,
     * и со значением, являющимся датой рождения животного
     */
    @Override
    public Map<String, LocalDate> findLeapYearNames() {

        Map<String, LocalDate> resultMap = new HashMap<>();

        for (Entry<String, List<Animal>> entry : animals.entrySet()) {
            for (Animal animal : entry.getValue()) {
                if (animal.getBirthDate().isLeapYear()) {
                    resultMap.put(
                            String.format("%s %s", entry.getKey(), animal.getName()),
                            animal.getBirthDate()
                    );
                }
            }
        }

        return resultMap;
    }


    /**
     * Ищет всех животных, которые старше N лет
     * @param age граничный возраст
     * @return Map с ключом, являющимся объектом животного,
     * и со значением, являющимся возрастом животного
     */
    @Override
    public Map<Animal, Integer> findOlderAnimal(int age) {

        Map<Animal, Integer> resultMap = new HashMap<>();

        int maxAnimalYear = Integer.MIN_VALUE;
        Animal oldestAnimal = null;

        for (Entry<String, List<Animal>> entry : animals.entrySet()) {
            for (Animal animal : entry.getValue()) {
                if (LocalDate.now().getYear() - animal.getBirthDate().getYear() > age) {
                    resultMap.put(
                            animal,
                            animal.getBirthDate().getYear()
                    );
                }
                if (LocalDate.now().getYear() - animal.getBirthDate().getYear() > maxAnimalYear) {
                    maxAnimalYear = LocalDate.now().getYear() - animal.getBirthDate().getYear();
                    oldestAnimal = animal;
                }
            }
        }

        if (resultMap.isEmpty()) {
            resultMap.put(
                    oldestAnimal,
                    maxAnimalYear
            );
        }

        return resultMap;
    }



    /**
     * Ищет всех повторяющихся животных и возвращает массив дубликатов
     * @return Map с ключом, являющимся типом животных
     * и значением, являющимся количеством дубликатов
     */
    @Override
    public Map<String, Integer> findDuplicate() {

        Map<String, Integer> resultMap = new HashMap<>();

        Set<Animal> uniqueAnimals = new HashSet<>();

        int counter;

        for (Entry<String, List<Animal>> entry : animals.entrySet()) {
            counter = 0;

            List<Animal> animalList = entry.getValue();

            for (int i = 0; i < animalList.size(); i++) {
                for (int j = i + 1; j < animalList.size(); j++) {
                    if (animalList.get(i).equals(animalList.get(j)) &&
                            i != j &&
                            !uniqueAnimals.contains(animalList.get(i))) {
                        uniqueAnimals.add(animalList.get(i));
                        counter++;
                    }
                }
            }

            if (counter != 0) {
                resultMap.put(
                        entry.getKey(),
                        counter
                );
            }
        }

        return resultMap;
    }

    /**
     * Выводит в консоль всех повторяющихся животных
     */
    @Override
    public void printDuplicate() {
        Map<String, Integer> duplicateAnimals = findDuplicate();

        for (Entry<String, Integer> entry : duplicateAnimals.entrySet()) {
            System.out.printf("%s=%d\n", entry.getKey(), entry.getValue());
        }
    }
}
