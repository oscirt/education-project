package org.example.application;

import org.example.animalsstarter.entity.animals.Shark;
import org.example.animalsstarter.repository.AnimalsRepositoryImpl;
import org.example.animalsstarter.service.interfaces.CreateAnimalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class AnimalsRepositoryTest {

    @Mock
    CreateAnimalService createAnimalService;

    @InjectMocks
    AnimalsRepositoryImpl animalsRepository;

    @BeforeEach
    public void init() {
        when(createAnimalService.createAnimals()).thenReturn(Map.of(
                "Shark",
                List.of(
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
                )
            )
        );

        animalsRepository.initAnimalArray();
    }

    @Test
    public void repositoryFindDuplicate() {
        assertFalse(animalsRepository.findDuplicate().isEmpty());
        verify(createAnimalService).createAnimals();
    }

    @Test
    public void repositoryFindOlderAnimal() {
        assertEquals(1, animalsRepository.findOlderAnimal(5).size());
        verify(createAnimalService).createAnimals();
    }
}
