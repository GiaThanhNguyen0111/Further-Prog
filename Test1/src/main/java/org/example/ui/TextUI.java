package org.example.ui;

import org.example.entity.DigitalProduct;
import org.example.entity.PhysicalProduct;
import org.example.entity.Product;
import org.example.entity.ShoppingCart;

import java.util.*;

public class TextUI {
    private Scanner scanner;
    private Map<String, Product> productMap;
    private List<ShoppingCart> carts;


    public TextUI() {
        this.scanner = new Scanner(System.in);
        this.productMap = new HashMap<>();
        this.carts = new ArrayList<>();
    }

    public void displayMenu() {
        System.out.println("1. Create Product");
        System.out.println("2. Edit Product");
        System.out.println("3. Create Shopping Cart");
        System.out.println("4. Add Product to Cart");
        System.out.println("5. Remove Product from Cart");
        System.out.println("6. Display Cart Amount");
        System.out.println("7. Display All Carts");
        System.out.println("8. Exit");
    }

    public void createProduct() {
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product description: ");
        String description = scanner.nextLine();
        System.out.println("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter price:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Is it a physical product? (Y/N)");
        String isPhysical = scanner.nextLine();
        Product product;

        if ("Y".equals(isPhysical)) {
            System.out.println("Enter weight: ");
            double weight = Double.parseDouble(scanner.nextLine());
            product = new PhysicalProduct(name, description, quantity, price, null, weight);
        } else {
            product = new DigitalProduct(name, description, quantity, price, null);
        }

        productMap.put(name, product);
        System.out.println("Product created successfully!");
    }

    public void editProduct() {
        System.out.println("Enter product name: ");
        String productName = scanner.nextLine();

        Product product = productMap.get(productName);
        System.out.println("Which field you want to edit?");
        System.out.println("1. Name");
        System.out.println("2. Description");
        System.out.println("3. Quantity");
        System.out.println("4. Price");

        if (product instanceof PhysicalProduct) {
            System.out.println("5. Weight");


            String field = scanner.nextLine();

            switch (field) {
                case "1":
                    System.out.println("Enter product name: ");
                    String name = scanner.nextLine();
                    product.setName(name);
                    break;
                case "2":
                    System.out.println("Enter product description: ");
                    String description = scanner.nextLine();
                    product.setDescription(description);
                    break;
                case "3":
                    System.out.println("Enter product quantity: ");
                    Integer qty = Integer.parseInt(scanner.nextLine());
                    product.setQuantity(qty);
                    break;
                case "4":
                    System.out.println("Enter product price: ");
                    Double price = Double.parseDouble(scanner.nextLine());
                    product.setPrice(price);
                    break;
                case "5":
                    System.out.println("Enter product weight: ");
                    Double weight = Double.parseDouble(scanner.nextLine());
                    assert product instanceof PhysicalProduct;
                    ((PhysicalProduct) product).setWeight(weight);
                    break;
            }

        }
    }

    public void createShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        carts.add(shoppingCart);
        System.out.println("Create cart successfully!!!");
    }

    public void addToCart() {
        ShoppingCart cart = carts.get(carts.size() - 1);
        displayAllProduct();
        String productName = "";

        while (!"F".equals(productName)) {
            displayAllProduct();
            System.out.println("Enter product name to add to cart or finish \"Press F\": ");
            productName = scanner.nextLine();
            cart.addItem(productName, productMap);
        }

    }

    private void displayAllProduct() {
        System.out.println("Product Menu: ");
        for (String key : productMap.keySet()) {
            Product product = productMap.get(key);
            if (product instanceof PhysicalProduct) {
                System.out.println(String.format("Name: %s\t\t" +
                                "Description: %s\t\t Quantity: %d\t\t " +
                                "Price: %f\t\t Weight: %f",
                        product.getName(), product.getDescription(), product.getQuantity(),
                        product.getPrice(), ((PhysicalProduct) product).getWeight()));

            } else {
                System.out.println(String.format("Name: %s\t\t" +
                                "Description: %s\t\t Quantity: %d\t\t " +
                                "Price: %f",
                        product.getName(), product.getDescription(), product.getQuantity(),
                        product.getPrice()));
            }
        }
    }

    public void displayCarts() {
        for(ShoppingCart cart: carts) {
            cart.displayCart();
        }
    }

    public void removeFromCart() {
        ShoppingCart cart = carts.get(carts.size() - 1);
        displayAllProduct();
        String productName = "";

        while (!"F".equals(productName)) {
            displayAllProduct();
            System.out.println("Enter product name to remove from cart or finish \"Press F\": ");
            productName = scanner.nextLine();
            cart.removeItem(productName, productMap);
        }
    }

    public void displayCartAmount() {
        ShoppingCart cart = carts.get(carts.size() - 1);
        System.out.println("Cart amount: " + cart.cartAmount(productMap));
    }
}
