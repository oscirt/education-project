package org.example.animalsstarter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.example.animalsstarter.entity.CalculatedSum;
import org.example.animalsstarter.entity.Product;
import org.example.animalsstarter.service.CalculateService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateServiceTest {

    @Test
    @DisplayName("Проверка сервиса счёта")
    public void calculateServiceCheck() {
        CalculatedSum sum;

        sum = CalculateService.calculate(new Product(10, 99.99, 0.75));
        assertEquals(sum.getSum().doubleValue(), 999.9);
        assertEquals(sum.getDiscountSum().doubleValue(), 992.4);

        sum = CalculateService.calculate(new Product(30, 9.99, 42.575));
        assertEquals(sum.getSum().doubleValue(), 299.7);
        assertEquals(sum.getDiscountSum().doubleValue(), 172.1);

        sum = CalculateService.calculate(new Product(50, 19.99, 59.1));
        assertEquals(sum.getSum().doubleValue(), 999.5);
        assertEquals(sum.getDiscountSum().doubleValue(), 408.8);
    }
}
