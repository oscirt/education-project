package ru.mts.repository.interfaces;

import ru.mts.entity.animals.Animal;

import java.util.List;

public interface AnimalsRepository {

    /**
     * Ищет имена всех животных, которые родились в високосный год
     * @return массив имен животных
     */
    String[] findLeapYearNames();

    /**
     * Ищет всех животных, которые старше N лет
     * @param age граничный возраст
     * @return массив животных
     */
    Animal[] findOlderAnimal(int age);

    /**
     * Ищет всех повторяющихся животных и возвращает массив дубликатов
     * @return массив дубликатов
     */
    List<Animal> findDuplicate();

    /**
     * Выводит в консоль всех повторяющихся животных
     */
    void printDuplicate();
}
