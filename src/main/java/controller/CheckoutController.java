package controller;

import customer.Customer;
import model.Cart;
import service.CheckoutService;

public class CheckoutController {
    public static void handleCheckout(Customer customer, Cart cart) {

        CheckoutService.checkout(customer, cart);
    }
}
