package org.example.animalsstarter.repository;

import org.example.animalsstarter.entity.animals.Animal;
import org.example.animalsstarter.repository.interfaces.AnimalsRepository;
import org.example.animalsstarter.service.interfaces.CreateAnimalService;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

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

        return animals.values().stream()
                .flatMap(Collection::stream)
                .filter(animal -> animal.getBirthDate().isLeapYear())
                .collect(
                        Collectors.toMap(
                                key -> String.format("%s %s", key.getClass().getSimpleName(), key.getName()),
                                Animal::getBirthDate,
                                (key1, key2) -> key1
                        )
                );
    }


    /**
     * Ищет всех животных, которые старше N лет
     * @param age граничный возраст
     * @return Map с ключом, являющимся объектом животного,
     * и со значением, являющимся возрастом животного
     */
    @Override
    public Map<Animal, Integer> findOlderAnimal(int age) {

        Map<Animal, Integer> resultMap = animals.values().stream()
                .flatMap(Collection::stream)
                .filter(animal -> LocalDate.now().getYear() - animal.getBirthDate().getYear() > age)
                .collect(Collectors.toMap(
                        key -> key,
                        value -> value.getBirthDate().getYear()
                ));

        if (resultMap.isEmpty()) {
            Optional<Animal> maxAnimal = animals.values().stream()
                    .flatMap(Collection::stream)
                    .min(Comparator.comparingInt((Animal a) -> a.getBirthDate().getYear()));
            if (maxAnimal.isPresent()) {
                Animal animal = maxAnimal.get();
                resultMap.put(
                        animal,
                        LocalDate.now().getYear() - animal.getBirthDate().getYear()
                );
            }
        }

        return resultMap;
    }



    /**
     * Ищет всех повторяющихся животных и возвращает массив дубликатов
     * @return Map с ключом, являющимся типом животных
     * и значением, являющимся количеством дубликатов
     */
    public Map<String, List<Animal>> findDuplicate() {

        return animals.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Entry::getKey)
                .collect(Collectors.groupingBy(
                        animal -> animal.getClass().getSimpleName(),
                        Collectors.toList()
                ));
    }

    /**
     * Выводит в консоль всех повторяющихся животных
     */
    @Override
    public void printDuplicate() {
        Map<String, List<Animal>> duplicateAnimals = findDuplicate();

        for (Entry<String, List<Animal>> entry : duplicateAnimals.entrySet()) {
            System.out.printf("%s=%s\n", entry.getKey(), entry.getValue());
        }
    }

    /**
     * Находит и выводит на экран средний возраст всех животных
     * @param animalList список животных
     */
    @Override
    public void findAverageAge(List<Animal> animalList) {
        Double averageAnimalYear = animalList.stream()
                .collect(
                        Collectors.averagingInt(
                                animal -> LocalDate.now().getYear() - animal.getBirthDate().getYear()
                        )
                );
        System.out.printf("Средний возраст животных: %f", averageAnimalYear);
    }

    /**
     * Находит животных, возраст которых больше 5 лет, а стоимость больше средней стоимости всех животных
     * @param animalList список животных
     * @return отсортированный по дате рождения (по возрастанию) список
     */
    @Override
    public List<Animal> findOldAndExpensive(List<Animal> animalList) {
        Double avgPrice = animalList.stream()
                .collect(
                        Collectors.averagingDouble(
                                animal -> animal.getCost().doubleValue()
                        )
                );

        return animalList.stream()
                .filter(animal -> LocalDate.now().getYear() - animal.getBirthDate().getYear() > 5 &&
                        animal.getCost().doubleValue() > avgPrice)
                .sorted(Comparator.comparing(Animal::getBirthDate))
                .collect(Collectors.toList());
    }

    /**
     * Находит 3 животных с самой низкой ценой
     * @param animalList список животных
     * @return список имен, отсортированный в обратном алфавитном порядке
     */
    @Override
    public List<String> findMinConstAnimals(List<Animal> animalList) {
        return animalList.stream()
                .sorted((Animal a1, Animal a2) -> a2.getCost().intValue() - a1.getCost().intValue())
                .limit(3)
                .sorted((Animal a1, Animal a2) -> -a1.getName().compareTo(a2.getName()))
                .map(Animal::getName)
                .collect(Collectors.toList());
    }
}
