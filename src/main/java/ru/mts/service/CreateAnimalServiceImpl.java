package ru.mts.service;

import ru.mts.model.animals.Cat;
import ru.mts.model.animals.Dog;
import ru.mts.model.animals.Shark;
import ru.mts.model.animals.Wolf;
import ru.mts.service.interfaces.CreateAnimalService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    public void createAnimalsNumber(int number) {
        System.out.println("\n*-----CreateAnimalServiceImpl int number-----*");
        Random random = new Random();
        for (int i = 0; i < number; i++) {
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
    }

    public void createAnimalsNumber(long number) {
        System.out.println("\n*-----CreateAnimalServiceImpl long number-----*");
        Random random = new Random();
        for (int i = 0; i < number; i++) {
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
    }

    @Override
    public void createAnimals() {
        System.out.println("\n*-----CreateAnimalServiceImpl-----*");
        int i = 0;
        Random random = new Random();
        do {
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
        } while (++i < 10);
    }
}
