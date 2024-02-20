package org.example.animalsstarter.service;

import org.example.animalsstarter.entity.animals.Animal;
import org.example.animalsstarter.entity.animals.AnimalType;
import org.example.animalsstarter.factory.AnimalFactory;
import org.example.animalsstarter.service.interfaces.CreateAnimalService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Scope("prototype")
public class CreateAnimalServiceImpl implements CreateAnimalService {

    public AnimalType animalType;

    private final AnimalFactory animalFactory;

    public CreateAnimalServiceImpl(AnimalFactory animalFactory) {
        this.animalFactory = animalFactory;
    }

    @Override
    public Animal generateRandomAnimal() {
        Random random = new Random();
        return animalFactory.createAnimal(random.nextInt(4));
    }

    @Override
    public Animal generateAnimal(AnimalType type) {
        return animalFactory.createAnimal(type.ordinal());
    }

    /**
     * Создает 10 животных случайного типа
     * @return 10 животных случайного типа
     */
    @Override
    public Animal[] createAnimals() {
        int i = 0;
        Animal[] animals = new Animal[10];
        do {
            animals[i] = generateAnimal(animalType);
        } while (++i < 10);
        return animals;
    }

    public void initAnimalType() {
        switch (new Random().nextInt(4)) {
            case 0:
                animalType = AnimalType.CAT;
                break;
            case 1:
                animalType = AnimalType.DOG;
                break;
            case 2:
                animalType = AnimalType.WOLF;
                break;
            case 3:
                animalType = AnimalType.SHARK;
                break;
        }
    }
}
