package ru.mts.model.animals;

import java.math.BigDecimal;

public abstract class AbstractAnimal implements Animal {

    // порода животного
    protected String breed;

    // имя животного
    protected String name;

    // цена в магазине
    protected BigDecimal cost;

    // характер
    protected String character;
}
