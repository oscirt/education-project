package org.example.application;

import org.example.animalsstarter.entity.animals.Animal;
import org.example.animalsstarter.entity.animals.Shark;
import org.example.animalsstarter.repository.AnimalsRepositoryImpl;
import org.example.animalsstarter.repository.interfaces.AnimalsRepository;
import org.example.animalsstarter.service.interfaces.CreateAnimalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class AnimalsRepositoryTest {

    AnimalsRepository animalsRepository;

    @Mock CreateAnimalService createAnimalService;

    @BeforeEach
    public void init() {
        when(createAnimalService.createAnimals()).thenReturn(new Animal[] {
                new Shark(
                        "Akula",
                        "Akula",
                        BigDecimal.valueOf(155L),
                        "Akula",
                        LocalDate.of(2023, 5, 13)
                ),
                new Shark(
                        "Akula",
                        "Akula",
                        BigDecimal.valueOf(155L),
                        "Akula",
                        LocalDate.of(2023, 5, 13)
                ),
                new Shark(
                        "Akulaa",
                        "Akulaa",
                        BigDecimal.valueOf(1555L),
                        "Akulaa",
                        LocalDate.of(2015, 4, 12)
                )
        });

        animalsRepository = new AnimalsRepositoryImpl(createAnimalService);
        ((AnimalsRepositoryImpl)animalsRepository).initAnimalArray();
    }

    @Test
    public void repositoryFindDuplicate() {
        assertFalse(animalsRepository.findDuplicate().isEmpty());
        verify(createAnimalService).createAnimals();
    }

    @Test
    public void repositoryFindOlderAnimal() {
        assertEquals(1, animalsRepository.findOlderAnimal(5).length);
        verify(createAnimalService).createAnimals();
    }
}
