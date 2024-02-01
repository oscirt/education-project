package ru.mts.entity.animals;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Animal {

    /**
     * Метод, который возвращает породу животного
     * @return возвращает породу животного
     */
    String getBreed();

    /**
     * Метод, который возвращает имя животного
     * @return возвращает имя животного
     */
    String getName();

    /**
     * Метод, который возвращает стоимость животного в магазине
     * Стоимость округляется до двух знаков после запятой
     * @return возвращает стоимость животного в магазине
     */
    BigDecimal getCost();

    /**
     * Метод, который возвращает характер животного
     * @return возвращает характер животного
     */
    String getCharacter();

    /**
     * Метод, который возвращает день рождения животного
     * @return возвращает день рождения животного
     */
    LocalDate getBirthDate();
}
