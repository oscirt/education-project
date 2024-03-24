package org.example.animalsstarter.exception.unchecked;

public class WrongAgeArgumentException extends IllegalArgumentException {
    public WrongAgeArgumentException(String message) {
        super(message);
    }
}