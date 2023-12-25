package ru.mts.service.interfaces;

import ru.mts.model.animals.Cat;
import ru.mts.model.animals.Dog;
import ru.mts.model.animals.Shark;
import ru.mts.model.animals.Wolf;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public interface CreateAnimalService {

    default void generateRandomAnimal() {
        Random random = new Random();
        switch (random.nextInt(4)) {
            case 0:
                System.out.println(new Cat(
                        "Порода кошки",
                        "Кошка",
                        BigDecimal.valueOf(random.nextDouble() * 100000)
                                .setScale(2, RoundingMode.HALF_UP),
                        "Характер кошки"
                ));
                break;
            case 1:
                System.out.println(new Dog(
                        "Порода собаки",
                        "Собака",
                        BigDecimal.valueOf(random.nextDouble() * 100000)
                                .setScale(2, RoundingMode.HALF_UP),
                        "Характер Собаки"
                ));
                break;
            case 2:
                System.out.println(new Wolf(
                        "Порода волка",
                        "Волк",
                        BigDecimal.valueOf(random.nextDouble() * 100000)
                                .setScale(2, RoundingMode.HALF_UP),
                        "Характер волка"
                ));
                break;
            case 3:
                System.out.println(new Shark(
                        "Порода акулы",
                        "Акула",
                        BigDecimal.valueOf(random.nextDouble() * 100000)
                                .setScale(2, RoundingMode.HALF_UP),
                        "Характер акулы"
                ));
                break;
        }
    }

    default void createAnimals() {
        System.out.println("*-----CreateAnimalService-----*");
        int i = 0;
        while (i < 10) {
            generateRandomAnimal();
            i++;
        }
    }
}
