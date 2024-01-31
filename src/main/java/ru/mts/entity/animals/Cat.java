package ru.mts.entity.animals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Cat extends Pet {

    public Cat(String breed, String name, BigDecimal cost, String character, LocalDate localDate) {
        super(breed, name, cost, character, localDate);
    }

    @Override
    public String getBreed() {
        return this.breed;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BigDecimal getCost() {
        return this.cost.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String getCharacter() {
        return this.character;
    }

    @Override
    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
