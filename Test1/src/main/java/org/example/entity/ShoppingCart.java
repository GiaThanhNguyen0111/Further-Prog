package org.example.entity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ShoppingCart implements Comparable<ShoppingCart> {
    private Set<String> products;

    private Double totalWeight;

    private final double BASE_FEE = 0.1;

    private final String ADD = "ADD";

    private final String DELETE = "DELETE";

    public ShoppingCart() {
        this.products = new HashSet<>();
        this.totalWeight = 0D;
    }

    public boolean addItem(String productName, Map<String, Product> productList) {
        if (isExistedInCart(productName)) {
            return false;
        }

        for (String key : productList.keySet()) {
            if (productName.equals(key)) {
                if (!productList.get(key).isLargerThanZero()) {
                    return false;
                }
                products.add(productName);
                Product product = productList.get(key);
                calculateTotalWeight(product, ADD);
                product.setQuantity(product.getQuantity() - 1);
                return true;
            }

        }

        return false;
    }

    public boolean removeItem(String productName, Map<String, Product> productList) {
        if (isExistedInCart(productName) || this.products.size() == 0) {
            return false;
        }

        for (String key : productList.keySet()) {
            if (!products.isEmpty() && productName.equals(key)) {
                products.remove(productName);
                Product product = productList.get(key);
                calculateTotalWeight(product, DELETE);
                product.setQuantity(product.getQuantity() + 1);
                return true;
            }
        }

        return false;
    }

    public void displayCart(){
        System.out.println("Current Cart: ");
        Iterator<String> it = products.iterator();
        int count = 1;
        while(it.hasNext()) {
            System.out.println(String.format("%d. %s", count, it.next()));
            count++;
        }
        System.out.println("Current Weight: " + totalWeight);
    }

    public double cartAmount(Map<String, Product> productList) {
        double totalFee = 0D;
        for (String product : products) {
            totalFee += productList.get(product).getPrice();
        }

        return totalFee + calculateShippingFee();
    }

    private double calculateShippingFee() {
        return totalWeight * BASE_FEE;
    }


    private void calculateTotalWeight(Product product, String actionType) {
        if (product instanceof PhysicalProduct) {
            if (actionType.equals(ADD)) {
                totalWeight += ((PhysicalProduct) product).getWeight();
            } else {
                totalWeight -= ((PhysicalProduct) product).getWeight();
            }

        }
    }

    private boolean isExistedInCart(String productName) {
        for (String product : products) {
            if (product.equals(productName)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int compareTo(ShoppingCart o) {
        return Double.compare(this.totalWeight, o.totalWeight);
    }
}
