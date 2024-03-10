package org.example.animalsstarter.repository.interfaces;

import org.example.animalsstarter.entity.animals.Animal;

import java.time.LocalDate;
import java.util.List;
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
    Map<String, List<Animal>> findDuplicate();

    /**
     * Выводит в консоль всех повторяющихся животных
     */
    void printDuplicate();

    /**
     * Находит и выводит на экран средний возраст всех животных
     * @param animalList список животных
     */
    void findAverageAge(List<Animal> animalList);

    /**
     * Находит животных, возраст которых больше 5 лет, а стоимость больше средней стоимости всех животных
     * @param animalList список животных
     * @return отсортированный по дате рождения (по возрастанию) список
     */
    List<Animal> findOldAndExpensive(List<Animal> animalList);

    /**
     * Находит 3 животных с самой низкой ценой
     * @param animalList список животных
     * @return список имен, отсортированный в обратном алфавитном порядке
     */
    List<String> findMinConstAnimals(List<Animal> animalList);
}
