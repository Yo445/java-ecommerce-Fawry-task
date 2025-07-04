import java.time.LocalDate;

import controller.CheckoutController;
import customer.Customer;
import model.Cart;
import model.NonExpirableProduct;
import model.Product;
import model.ShippableProduct;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Youssef", 4000);
        Product cheese = new ShippableProduct("Cheese", 100, 10, LocalDate.now().plusDays(3), 0.2);
//        Product tv = new ShippableProduct("TV", 1000, 5, LocalDate.now().plusDays(365), 5.0);
//        Product expiredCheese = new ShippableProduct("Cheese", 100, 10, LocalDate.now().minusDays(1), 0.4);
        Product tv = new ShippableProduct("TV", 1000, 2, LocalDate.now().plusDays(100), 5.0);
        Product scratchCard = new NonExpirableProduct("Scratch Card", 50, 5);

        Cart cart = new Cart();
//        cart.add(expiredCheese, 1);
//        cart.add(cheese, 2);         // 200
//        cart.add(tv, 3);             // 3000
        cart.add(scratchCard, 2);    // 50

        CheckoutController.handleCheckout(customer, cart);

    }
}