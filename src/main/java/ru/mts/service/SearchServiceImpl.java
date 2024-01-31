package ru.mts.service;

import ru.mts.entity.animals.Animal;
import ru.mts.service.interfaces.SearchService;

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
    public String[] findLeapYearNames(Animal[] animals) {
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
     * @param animals массив животных
     * @param age граничный возраст
     * @return массив животных, старше N лет
     */
    @Override
    public Animal[] findOlderAnimal(Animal[] animals, int age) {
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
     * Ищет всех повторяющихся животных в массиве и выводит их в консоль
     * @param animals массив животных
     */
    @Override
    public List<Animal> findDuplicate(Animal[] animals) {
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

    @Override
    public void printDuplicate(Animal[] animals) {
        List<Animal> duplicateAnimals = findDuplicate(animals);
        duplicateAnimals.forEach(animal -> System.out.printf("Duplicate animal: %s\n", animal));
    }
}
