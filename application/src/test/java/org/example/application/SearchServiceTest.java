package org.example.application;

import org.example.animalsstarter.entity.animals.*;
import org.example.animalsstarter.service.SearchServiceImpl;
import org.example.animalsstarter.service.interfaces.SearchService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SearchServiceTest {

    public static SearchService searchService;

    @BeforeAll
    public static void setupService() {
        searchService = new SearchServiceImpl();
    }

    @Nested
    class AnimalEqualsTests {

        @Test
        @DisplayName("Сравнение одинаковых животных")
        public void animalEqualsTest1() {
            Wolf wolf1 = new Wolf("Wolf", "wolf", BigDecimal.valueOf(1000), "character",
                    LocalDate.of(2003, 6, 5));
            Wolf wolf2 = new Wolf("Wolf", "wolf", BigDecimal.valueOf(1000), "character",
                    LocalDate.of(2003, 6, 5));

            assertEquals(wolf1, wolf2);
        }

        @Test
        @DisplayName("Сравнение разных животных")
        public void animalEqualsTest2() {
            Wolf wolf1 = new Wolf("Wolf", "wolf", BigDecimal.valueOf(1000), "character",
                    LocalDate.of(2003, 6, 5));
            Wolf wolf2 = new Wolf("Wolf", "wolf", BigDecimal.valueOf(10000), "character",
                    LocalDate.of(2003, 6, 5));

            assertNotEquals(wolf1, wolf2);
        }

        @Test
        @DisplayName("Сравнение животных разных классов")
        public void animalEqualsTest3() {
            Wolf wolf1 = new Wolf("Wolf", "wolf", BigDecimal.valueOf(1000), "character",
                    LocalDate.of(2003, 6, 5));
            Dog dog = new Dog("Dog", "dog", BigDecimal.valueOf(20), "character",
                    LocalDate.of(2000, 12, 13));

            assertNotEquals(wolf1, dog);
        }
    }

    @Nested
    class SearchServiceTests {

        @Test
        @DisplayName("Проверка корректности метода findLeapYearNamesTest()")
        public void findLeapYearNamesTest() {
            Dog dog = new Dog("Dog", "dog", BigDecimal.valueOf(20), "character",
                    LocalDate.of(2000, 12, 13));
            Cat cat = new Cat("Cat", "dog", BigDecimal.valueOf(100), "character",
                    LocalDate.of(1900, 3, 4));
            Wolf wolf = new Wolf("Wolf", "wolf", BigDecimal.valueOf(1000), "character",
                    LocalDate.of(2003, 6, 5));
            Shark shark = new Shark("Shark", "shark", BigDecimal.valueOf(10000), "character",
                    LocalDate.of(2020, 1, 3));

            List<Animal> animals = List.of(dog, cat, wolf, shark);
            assertEquals(List.of("dog", "shark"), searchService.findLeapYearNames(animals));
        }

        @ParameterizedTest
        @ValueSource(ints = { 4, 5, 6 })
        @DisplayName("Проверка корректности метода findOlderAnimalTest()")
        public void findOlderAnimalTest(int age) {
            Dog dog = new Dog("Dog", "dog", BigDecimal.valueOf(20), "character",
                    LocalDate.of(2000, 12, 13));
            Cat cat = new Cat("Cat", "dog", BigDecimal.valueOf(100), "character",
                    LocalDate.of(2021, 3, 4));
            Wolf wolf = new Wolf("Wolf", "wolf", BigDecimal.valueOf(1000), "character",
                    LocalDate.of(2003, 6, 5));
            Shark shark = new Shark("Shark", "shark", BigDecimal.valueOf(10000), "character",
                    LocalDate.of(2020, 1, 3));

            List<Animal> animals = List.of(dog, cat, wolf, shark);
            assertEquals(List.of(dog, wolf), searchService.findOlderAnimal(animals, age));
        }

        @Test
        @DisplayName("Проверка корректности метода findDuplicate()")
        public void findDuplicate() {
            Dog dog = new Dog("Dog", "dog", BigDecimal.valueOf(220), "character",
                    LocalDate.of(2000, 12, 13));
            Cat cat = new Cat("Cat", "dog", BigDecimal.valueOf(100), "character",
                    LocalDate.of(2021, 3, 4));
            Wolf wolf = new Wolf("Wolf", "wolf", BigDecimal.valueOf(1000), "character",
                    LocalDate.of(2003, 6, 5));
            Shark shark = new Shark("Shark", "shark", BigDecimal.valueOf(10000), "character",
                    LocalDate.of(2020, 1, 3));
            Dog dog1 = new Dog("Dog", "dog", BigDecimal.valueOf(20), "character",
                    LocalDate.of(2000, 12, 13));
            Cat cat1 = new Cat("Cat", "dog", BigDecimal.valueOf(100), "character",
                    LocalDate.of(2021, 3, 4));
            Wolf wolf1 = new Wolf("Wolf", "wolf", BigDecimal.valueOf(10020), "character",
                    LocalDate.of(2003, 6, 5));
            Shark shark1 = new Shark("Shark", "shark", BigDecimal.valueOf(10000), "character",
                    LocalDate.of(2020, 1, 3));

            List<Animal> animals = List.of(dog, dog1, cat, cat1, wolf, wolf1, shark, shark1);

            assertEquals(List.of(cat, shark), searchService.findDuplicate(animals));
        }
    }
}
