package org.example.animalsstarter.service.interfaces;

import org.example.animalsstarter.entity.animals.Animal;

import java.util.List;

public interface SearchService {

    List<String> findLeapYearNames(List<Animal> animals);

    /**
     * Ищет всех животных, которые старше N лет
     * @param animals массив животных
     * @param age граничный возраст
     * @return массив животных
     */
    List<Animal> findOlderAnimal(List<Animal> animals, int age);

    /**
     * Ищет всех повторяющихся животных в массиве и выводит их в поток вывода
     * @param animals массив животных
     */
    List<Animal> findDuplicate(List<Animal> animals);

    /**
     * Выводит в консоль всех повторяющихся животных
     * @param animals массив животных
     */
    void printDuplicate(List<Animal> animals);
}
