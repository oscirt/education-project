package ru.mts.model;

import java.math.BigDecimal;

public class CalculatedSum {

    private BigDecimal sum;
    private BigDecimal discountSum;

    public CalculatedSum(BigDecimal sum, BigDecimal discountSum) {
        this.sum = sum;
        this.discountSum = discountSum;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public BigDecimal getDiscountSum() {
        return discountSum;
    }

    public void setDiscountSum(BigDecimal discountSum) {
        this.discountSum = discountSum;
    }
}
