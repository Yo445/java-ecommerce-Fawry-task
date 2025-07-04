package model;

import java.time.LocalDate;

public class NonShippableProduct extends ExpirableProduct {
    public NonShippableProduct(String name, double price, int quantity, LocalDate expirationDate) {
        super(name, price, quantity, expirationDate);
    }
}
