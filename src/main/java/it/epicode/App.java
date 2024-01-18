package it.epicode;

import it.epicode.entities.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class App {
 public static void main(String[] args) {
  List<Product> listaProdotti = new ArrayList<>();
  Product p1 = new Product("Harry Potter", "Books", 110);
  Product p2 = new Product("The Hobbit", "Books", 40);
  Product p3 = new Product("The Da Vinci Code", "Books", 127.5);
  Product p4 = new Product("The Godfather", "Books", 71.5);
  Product p5 = new Product("Adventures of Huckleberry Finn", "Books", 41.5);
  Product p6 = new Product("Culla", "Baby", 52.5);
  Product p7 = new Product("Pannolini", "Baby", 47.5);
  Product p8 = new Product("Scarpe", "Boy", 60);
  Product p9 = new Product("Pantaloni", "Boy", 23);
  Product p10 = new Product("Maglietta", "Boy", 28);

  listaProdotti.add(p1);
  listaProdotti.add(p2);
  listaProdotti.add(p3);
  listaProdotti.add(p4);
  listaProdotti.add(p5);
  listaProdotti.add(p6);
  listaProdotti.add(p7);
  listaProdotti.add(p8);
  listaProdotti.add(p9);
  listaProdotti.add(p10);

  Customer c1 = new Customer("Mario", 1);
  Customer c2 = new Customer("Luigi", 2);
  Customer c3 = new Customer("Giuseppe", 3);

  List<Product> listaProdottiDiMario = new ArrayList<>();
  listaProdottiDiMario.add(p6);
  listaProdottiDiMario.add(p7);
  List<Product> listaProdottiDiLuigi = new ArrayList<>();
  listaProdottiDiLuigi.add(p9);
  listaProdottiDiLuigi.add(p10);
  List<Product> listaProdottiDiGiuseppe = new ArrayList<>();
  listaProdottiDiGiuseppe.add(p1);
  listaProdottiDiGiuseppe.add(p2);
  listaProdottiDiGiuseppe.add(p3);

  LocalDate d1 = LocalDate.of(2021, 10, 10);
  LocalDate d2 = LocalDate.of(2021, 2, 10);
  LocalDate d3 = LocalDate.of(2021, 3, 15);

  Order o1 = new Order("Completed", d1, listaProdottiDiMario, c1);
  Order o2 = new Order("Pending", d2, listaProdottiDiLuigi, c2);
  Order o3 = new Order("Shipped", d3, listaProdottiDiGiuseppe, c3);

  List<Order> listaOrder = new ArrayList<>();
  listaOrder.add(o1);
  listaOrder.add(o2);
  listaOrder.add(o3);

// raggruppa gli ordini per cliente
  Map<Customer, List<Order>> ordersPerCustomer = listaOrder.stream()
          .collect(Collectors.groupingBy(Order::getCustomer));

  // calcola il totale delle vendite per ogni cliente
  Map<Object, Double> orderByCustomerTotal = listaOrder.stream().collect(Collectors.groupingBy(Order::getCustomer,
          Collectors.summingDouble(order -> order.getProduct().stream().mapToDouble(Product::getPrice).sum())));
  orderByCustomerTotal.forEach((customer, total) -> System.out.println(customer + " Totale: " + total));
  System.out.println();

  // trova i prodotti più costosi
  List<Product> mostExpensiveProducts = listaProdotti.stream()
          .sorted(Comparator.comparing(Product::getPrice).reversed())
          .limit(3)
          .toList();

  // calcola la media degli importi degli ordini
  double averageOrderTotal = listaOrder.stream()
          .mapToDouble(order -> order.getProduct().stream().mapToDouble(Product::getPrice).sum()).average().getAsDouble();

  // raggruppa i prodotti per categoria e calcola la somma
  Map<String, Double> categoriaTotale = listaProdotti.stream().collect(Collectors.groupingBy(Product::getCategory,
          Collectors.summingDouble(Product::getPrice)));


  System.out.println("Ordini per customer: " + ordersPerCustomer);
  System.out.println("Totale spesa per customer: " + orderByCustomerTotal);
  System.out.println("Prodotti piú costosi: " + mostExpensiveProducts);
  System.out.println("Spesa media degli ordini: " + averageOrderTotal);
  categoriaTotale.forEach((categoria, somma) -> System.out.println("Categoria: " + categoria + ", Totale: " + somma));
 }
}

