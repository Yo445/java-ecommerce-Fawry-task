package model;

import java.time.LocalDate;

public class ShippableProduct extends ExpirableProduct implements Shippable {
    private double weight;

    public ShippableProduct(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity, expiryDate);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
