package org.example.animalsstarter.service;

import org.example.animalsstarter.entity.animals.Animal;
import org.example.animalsstarter.service.interfaces.SearchService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SearchServiceImpl implements SearchService {

    /**
     * Ищет имена всех животных, которые родились в високосный год
     * @param animals массив животных
     * @return массив имен животных
     */
    @Override
    public List<String> findLeapYearNames(List<Animal> animals) {

        List<String> resultList = new ArrayList<>();

        for (Animal animal : animals) {
            if (animal.getBirthDate().isLeapYear()) {
                resultList.add(animal.getName());
            }
        }

        return resultList;
    }

    /**
     * Ищет всех животных, которые старше N лет
     * @param animals массив животных
     * @param age граничный возраст
     * @return массив животных, старше N лет
     */
    @Override
    public List<Animal> findOlderAnimal(List<Animal> animals, int age) {

        List<Animal> resultList = new ArrayList<>();

        for (Animal animal : animals) {
            if (LocalDate.now().getYear() - animal.getBirthDate().getYear() > age) {
                resultList.add(animal);
            }
        }

        return resultList;
    }

    /**
     * Ищет всех повторяющихся животных в массиве и выводит их в консоль
     * @param animals массив животных
     */
    @Override
    public List<Animal> findDuplicate(List<Animal> animals) {

        List<Animal> resultAnimals = new ArrayList<>();

        for (int i = 0; i < animals.size(); i++) {
            for (int j = i + 1; j < animals.size(); j++) {
                if (animals.get(i).equals(animals.get(j)) &&
                        i != j &&
                        !resultAnimals.contains(animals.get(i)) &&
                        !resultAnimals.contains(animals.get(j))) {
                    resultAnimals.add(animals.get(i));
                }
            }
        }

        return resultAnimals;
    }

    @Override
    public void printDuplicate(List<Animal> animals) {
        List<Animal> duplicateAnimals = findDuplicate(animals);
        duplicateAnimals.forEach(animal -> System.out.printf("Duplicate animal: %s\n", animal));
    }
}
