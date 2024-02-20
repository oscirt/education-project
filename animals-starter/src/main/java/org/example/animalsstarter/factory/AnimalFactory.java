package org.example.animalsstarter.factory;

import org.example.animalsstarter.config.AnimalsProperties;
import org.example.animalsstarter.entity.animals.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Random;

@Component
@Scope(value = "singleton")
public class AnimalFactory {

    private AnimalsProperties animalsProperties;

    public AnimalFactory(AnimalsProperties animalsProperties) {
        this.animalsProperties = animalsProperties;
    }

    /**
     * Метод, создающий одно из четырех животных
     * @param type тип создаваемого животного
     * @return созданное животное
     */
    public Animal createAnimal(int type) {
        Random random = new Random();
        switch (type) {
            case 0:
                return new Cat(
                    "Порода кошки",
                    animalsProperties.getCatNames().get(random.nextInt(animalsProperties.getCatNames().size())),
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
                    animalsProperties.getDogNames().get(random.nextInt(animalsProperties.getDogNames().size())),
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
                    animalsProperties.getSharkNames().get(random.nextInt(animalsProperties.getSharkNames().size())),
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
                        animalsProperties.getWolfNames().get(random.nextInt(animalsProperties.getWolfNames().size())),
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
