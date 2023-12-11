package ru.mts.service;

import ru.mts.model.CalculatedSum;
import ru.mts.model.Product;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CalculateService {

    private final MathContext context = new MathContext(5, RoundingMode.HALF_UP);

    public CalculatedSum calculate(Product product) {
    double withoutDiscount = product.getCost() * product.getCount();
        return new CalculatedSum(
                new BigDecimal(withoutDiscount, context),
                new BigDecimal(withoutDiscount * (100 - product.getDiscount()) / 100, context)
        );
    }
}
