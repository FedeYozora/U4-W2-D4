package it.epicode.entities;

import java.util.Random;

public class Customer {
    private Long id;
    private String name;
    private Integer tier;

    public Customer(String name, Integer tier) {
        Random random = new Random();
        this.id = random.nextLong();
        this.name = name;
        this.tier = tier;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", id=" + id + "]";
    }
}
