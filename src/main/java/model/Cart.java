package model;

import java.util.*;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (product.isAvailable(quantity)) {
            items.add(new CartItem(product, quantity));
        } else {
            System.out.println("Not enough stock for " + product.getName());
        }
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public List<Shippable> getShippableItems() {
        List<Shippable> list = new ArrayList<>();
        for (CartItem item : items) {
            if (item.isShippable()) {
                for (int i = 0; i < item.quantity; i++) {
                    list.add((Shippable) item.product);
                }
            }
        }
        return list;
    }
}
