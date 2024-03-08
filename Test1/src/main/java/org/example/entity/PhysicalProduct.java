package org.example.entity;

public class PhysicalProduct extends Product{

    private Double weight;

    public PhysicalProduct(String name, String description, Integer qty, Double price, String message, Double weight) {
        super(name, description, qty, price, message);
        this.weight = weight;

    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PHYSICAL" + this.getName();
    }
}
