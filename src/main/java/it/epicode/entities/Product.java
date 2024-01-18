package it.epicode.entities;

import java.util.Random;

public class Product {
    private Long id;
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        Random random = new Random();
        this.id = random.nextLong();
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}