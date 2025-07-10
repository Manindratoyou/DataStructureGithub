package com.manindra.stream;

import java.util.*;
import java.util.stream.Collectors;

public class ProductDemo {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1, "Pen", 25.0, "Stationery"),
                new Product(2, "Notebook", 55.0, "Stationery"),
                new Product(3, "Backpack", 120.0, "Bags"),
                new Product(4, "Mouse", 250.0, "Electronics"),
                new Product(5, "USB Cable", 80.0, "Electronics")
        );

        // 1. Print the names of products below threshold (e.g., 100)
        System.out.println("Products below price 100:");
        products.stream()
                .filter(p -> p.getPrice() < 100)
                .map(Product::getName)
                .forEach(System.out::println);

        // 2. Create a new list with 20% price reduction
        List<Product> discountedProducts = products.stream()
                .map(p -> new Product(
                        p.getId(),
                        p.getName(),
                        p.getPrice() * 0.8, // 20% off
                        p.getCategory()))
                .collect(Collectors.toList());

        List<Product> discountedProducts1 = products.stream()
                .map(
                        product -> {
                            double discountPrice = product.getPrice() * 0.80;
                            product.setPrice(discountPrice);
                            return product;
                        }
                )
                .collect(Collectors.toList());

        System.out.println("\nDiscounted Products (20% off):");
        discountedProducts.forEach(System.out::println);

        // 3. Calculate the average price
        double averagePrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);

        System.out.println("\nAverage Price: " + averagePrice);

        // 4. Find the product with the lowest price
        Product cheapestProduct = products.stream()
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElse(null);

        Product cheapestProduct1 = products.stream()
                .min((x1,x2)->Double.compare(x1.getPrice(),x2.getPrice()))
                .orElse(null);

        System.out.println("\nProduct with lowest price: " + cheapestProduct);
    }

    static class Product {
        private int id;
        private String name;
        private double price;
        private String category;

        public Product(int id, String name, double price, String category) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.category = category;
        }

        // Getters
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public String getCategory() {
            return category;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return name + " ($" + price + ")";
        }
    }

}

