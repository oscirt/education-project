package ru.mts;

public class Main {

    public static void main(String[] args) {
        calculate(new Product(10, 99.99, 0.75));
        calculate(new Product(30, 9.99, 42.575));
        calculate(new Product(50, 19.99, 59.1));
    }

    public static void calculate(Product product) {
        double withoutDiscount = product.getCost() * product.getCount();
        System.out.printf("Стоимость без скидки: %.2f\t", withoutDiscount);
        System.out.printf("Стоимость со скидкой: %.2f\n", withoutDiscount * (100 - product.getDiscount()) / 100);
    }
}