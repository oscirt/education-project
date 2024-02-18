package org.example.animalsstarter.service;

import org.example.animalsstarter.entity.CalculatedSum;
import org.example.animalsstarter.entity.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculateService {

    public static CalculatedSum calculate(Product product) {
        double sumWithoutDiscount = product.getCost() * product.getCount();
        double sumWithDiscount = sumWithoutDiscount * (100 - product.getDiscount()) / 100;
        return new CalculatedSum(
                new BigDecimal(sumWithoutDiscount)
                        .setScale(2, RoundingMode.HALF_UP),
                new BigDecimal(sumWithDiscount)
                        .setScale(2, RoundingMode.HALF_UP)
        );
    }
}
