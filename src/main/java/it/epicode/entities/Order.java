package it.epicode.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Order {
    private Long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> product;
    private Customer customer;

    public Order(String status, LocalDate orderDate, List<Product> product, Customer customer) {
        Random random = new Random();
        this.id = random.nextLong();
        this.status = status;
        this.orderDate = orderDate;
        this.product = product;
        this.customer = customer;
    }

    public List<Product> getProduct() {
        return product;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", product=" + product +
                ", customer=" + customer.getName() +
                '}';
    }
}