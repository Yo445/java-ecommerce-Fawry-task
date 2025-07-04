package service;
import java.util.List;
import customer.Customer;
import model.Cart;
import model.CartItem;
import model.Shippable;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        for (CartItem item : cart.getItems()) {
            if (item.product.isExpired()) {
                System.out.println("Error: " + item.product.getName() + " is expired.");
                return;
            }
            if (!item.product.isAvailable(item.quantity)) {
                System.out.println("Error: Not enough stock for " + item.product.getName());
                return;
            }
        }

        double subtotal = cart.getSubtotal();
        List<Shippable> shippables = cart.getShippableItems();
        double shipping = ShippingService.calculateShipping(shippables);
        double total = subtotal + shipping;

        if (!customer.canPay(total)) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        // reduce product quantities
        for (CartItem item : cart.getItems()) {
            item.product.reduceQuantity(item.quantity);
        }

        customer.deduct(total);

        ShippingService.ship(shippables);

        // Print receipt
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            String nameWithQty = item.quantity + "x " + item.product.getName();
            double totalPrice = item.getTotalPrice() * item.quantity;
            System.out.printf("%-20s %.2f%n", nameWithQty, totalPrice);
        }

        System.out.println("----------------------");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shipping);
        System.out.println("Amount: " + total);
    }
}
