package ru.mts.factory;

import ru.mts.entity.animals.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class AnimalFactory {

    /**
     * Метод, создающий одно из четырех животных
     * @param type тип создаваемого животного
     * @return созданное животное
     */
    public static Animal createAnimal(int type) {
        switch (type) {
            case 0:
                return new Cat(
                        "Порода кошки",
                        "Кошка",
                        BigDecimal.valueOf(100)
                                .setScale(2, RoundingMode.HALF_UP),
                        "Характер кошки",
                        LocalDate.of(2000, 10, 10)
                );
            case 1:
                return new Dog(
                        "Порода собаки",
                        "Собака",
                        BigDecimal.valueOf(500)
                                .setScale(2, RoundingMode.HALF_UP),
                        "Характер Собаки",
                        LocalDate.of(2010, 5, 18)
                );
            case 2:
                return new Shark(
                        "Порода акулы",
                        "Акула",
                        BigDecimal.valueOf(100000)
                                .setScale(2, RoundingMode.HALF_UP),
                        "Характер акулы",
                        LocalDate.of(2030, 8, 20)
                );
            case 3:
                return new Wolf(
                        "Порода волка",
                        "Волк",
                        BigDecimal.valueOf(1000)
                                .setScale(2, RoundingMode.HALF_UP),
                        "Характер волка",
                        LocalDate.of(2020, 4, 9)
                );
        }

        throw new IllegalArgumentException();
    }
}
