package ru.mts.service.interfaces;

import ru.mts.entity.animals.Animal;

import java.util.List;

public interface SearchService {

    String[] findLeapYearNames(Animal[] animals);

    /**
     * Ищет всех животных, которые старше N лет
     * @param animals массив животных
     * @param age граничный возраст
     * @return массив животных
     */
    Animal[] findOlderAnimal(Animal[] animals, int age);

    /**
     * Ищет всех повторяющихся животных в массиве и выводит их в поток вывода
     * @param animals массив животных
     */
    List<Animal> findDuplicate(Animal[] animals);

    /**
     * Выводит в консоль всех повторяющихся животных
     * @param animals массив животных
     */
    void printDuplicate(Animal[] animals);
}
