package service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Shippable;

public class ShippingService {
    public static double calculateShipping(List<Shippable> items) {
        double totalWeight = items.stream().mapToDouble(Shippable::getWeight).sum();
        return totalWeight * 30;
    }

    public static void ship(List<Shippable> items) {
        if (items.isEmpty()) return;
        System.out.println("** Shipment notice **");
        Map<String, Integer> itemCount = new HashMap<>();
        Map<String, Double> itemWeight = new HashMap<>();
        double totalWeight = 0;
        for (Shippable item : items) {
            itemCount.put(item.getName(), itemCount.getOrDefault(item.getName(), 0) + 1);
            itemWeight.putIfAbsent(item.getName(), item.getWeight());
            totalWeight += item.getWeight();
        }
        for (String name : itemCount.keySet()) {
            double quantity = itemCount.get(name);
            double weightInGrams = itemWeight.get(name) * 1000 * quantity;
            System.out.printf("%-20s %6.0fg%n", quantity + "x " + name, weightInGrams);
        }
        System.out.printf("Total package weight: %.1fkg%n%n", totalWeight);

    }
}
