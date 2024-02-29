package org.example.animalsstarter.repository.interfaces;

import org.example.animalsstarter.entity.animals.Animal;

import java.time.LocalDate;
import java.util.Map;

public interface AnimalsRepository {

    /**
     * Ищет имена всех животных, которые родились в високосный год
     * @return Map с ключом, являющимся строкой с типом животного и его именем,
     * и со значением, являющимся датой рождения животного
     */
    Map<String, LocalDate> findLeapYearNames();

    /**
     * Ищет всех животных, которые старше N лет
     * @param age граничный возраст
     * @return Map с ключом, являющимся объектом животного,
     * и со значением, являющимся возрастом животного
     */
    Map<Animal, Integer> findOlderAnimal(int age);

    /**
     * Ищет всех повторяющихся животных и возвращает массив дубликатов
     * @return Map с ключом, являющимся типом животных
     * и значением, являющимся количеством дубликатов
     */
    Map<String, Integer> findDuplicate();

    /**
     * Выводит в консоль всех повторяющихся животных
     */
    void printDuplicate();
}
