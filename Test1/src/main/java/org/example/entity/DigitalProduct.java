package org.example.entity;

public class DigitalProduct extends Product{

    public DigitalProduct(String name, String description, Integer quantity, Double price, String message) {
        super(name, description, quantity, price, message);
    }

    @Override
    public String toString() {
        return "DIGITAL" + this.getName();
    }
}
