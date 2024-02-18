package org.example.animalsstarter.entity.animals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public abstract class AbstractAnimal implements Animal {

    // порода животного
    protected String breed;

    // Имя животного
    protected String name;

    // Цена в магазине
    protected BigDecimal cost;

    // Характер
    protected String character;

    // День рождения
    protected LocalDate birthDate;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractAnimal that = (AbstractAnimal) obj;
        return Objects.equals(breed, that.breed) &&
                Objects.equals(name, that.name) &&
                Objects.equals(cost, that.cost) &&
                Objects.equals(birthDate, that.birthDate);
    }
}
