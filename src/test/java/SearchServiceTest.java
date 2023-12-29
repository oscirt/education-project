import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.mts.model.animals.*;
import ru.mts.service.SearchServiceImpl;
import ru.mts.service.interfaces.SearchService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SearchServiceTest {

    public static SearchService searchService;

    @BeforeAll
    public static void setupService() {
        searchService = new SearchServiceImpl();
    }

    @Test
    public void findLeapYearNames() {
        Dog dog = new Dog("Dog", "dog", BigDecimal.valueOf(20), "character",
                LocalDate.of(2000, 12, 13));
        Cat cat = new Cat("Cat", "dog", BigDecimal.valueOf(100), "character",
                LocalDate.of(1900, 3, 4));
        Wolf wolf = new Wolf("Wolf", "wolf", BigDecimal.valueOf(1000), "character",
                LocalDate.of(2003, 6, 5));
        Shark shark = new Shark("Shark", "shark", BigDecimal.valueOf(10000), "character",
                LocalDate.of(2020, 1, 3));

        Animal[] animals = {dog, cat, wolf, shark};
        Assertions.assertArrayEquals(new String[]{"dog", "shark"}, searchService.findLeapYearNames(animals));
    }

    @Test
    public void findOlderAnimal() {
        Dog dog = new Dog("Dog", "dog", BigDecimal.valueOf(20), "character",
                LocalDate.of(2000, 12, 13));
        Cat cat = new Cat("Cat", "dog", BigDecimal.valueOf(100), "character",
                LocalDate.of(2021, 3, 4));
        Wolf wolf = new Wolf("Wolf", "wolf", BigDecimal.valueOf(1000), "character",
                LocalDate.of(2003, 6, 5));
        Shark shark = new Shark("Shark", "shark", BigDecimal.valueOf(10000), "character",
                LocalDate.of(2020, 1, 3));

        Animal[] animals = {dog, cat, wolf, shark};
        Assertions.assertArrayEquals(new Animal[]{dog, wolf}, searchService.findOlderAnimal(animals, 5));
    }
}
