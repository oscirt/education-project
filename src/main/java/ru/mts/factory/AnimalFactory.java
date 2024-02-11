package ru.mts.factory;

import ru.mts.entity.animals.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Random;

public class AnimalFactory {

    /**
     * Метод, создающий одно из четырех животных
     * @param type тип создаваемого животного
     * @return созданное животное
     */
    public static Animal createAnimal(int type) {
        Random random = new Random();
        switch (type) {
            case 0:
                return new Cat(
                    "Порода кошки",
                    "Кошка",
                    BigDecimal.valueOf(random.nextInt(10000))
                            .setScale(2, RoundingMode.HALF_UP),
                    "Характер кошки",
                    LocalDate.of(
                            random.nextInt(20) + 2000,
                            random.nextInt(12) + 1,
                            random.nextInt(28) + 1
                    )
                );
            case 1:
                return new Dog(
                    "Порода собаки",
                    "Собака",
                    BigDecimal.valueOf(random.nextInt(10000))
                            .setScale(2, RoundingMode.HALF_UP),
                    "Характер Собаки",
                    LocalDate.of(
                            random.nextInt(20) + 2000,
                            random.nextInt(12) + 1,
                            random.nextInt(28) + 1
                    )
                );
            case 2:
                return new Shark(
                    "Порода акулы",
                    "Акула",
                    BigDecimal.valueOf(random.nextInt(100000))
                            .setScale(2, RoundingMode.HALF_UP),
                    "Характер акулы",
                    LocalDate.of(
                            random.nextInt(20) + 2000,
                            random.nextInt(12) + 1,
                            random.nextInt(28) + 1
                    )
                );
            case 3:
                return new Wolf(
                        "Порода волка",
                        "Волк",
                        BigDecimal.valueOf(random.nextInt(100000))
                                .setScale(2, RoundingMode.HALF_UP),
                        "Характер волка",
                        LocalDate.of(
                                random.nextInt(20) + 2000,
                                random.nextInt(12) + 1,
                                random.nextInt(28) + 1
                        )
                );
        }

        throw new IllegalArgumentException();
    }
}
