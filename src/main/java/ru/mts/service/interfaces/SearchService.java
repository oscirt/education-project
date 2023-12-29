package ru.mts.service.interfaces;

import ru.mts.model.animals.Animal;

public interface SearchService {

    /**
     * Ищет имена всех животных, которые родились в високосный год
     * @param animals массив животных
     * @return массив имен животных
     */
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
    void findDuplicate(Animal[] animals);
}
