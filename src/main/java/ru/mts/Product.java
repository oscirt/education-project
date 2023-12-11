package ru.mts;

/**
 * {@link Product} предназначен для описания товара
 *
 * @author Kadyrov Amir
 */
public class Product {

    // Количество товара
    private int count;

    // Сумма товара за 1 единицу
    private double cost;

    // Скидка на товар
    private double discount;

    Product(int count, double cost, double discount) {
        this.count = count;
        this.cost = cost;
        this.discount = discount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
