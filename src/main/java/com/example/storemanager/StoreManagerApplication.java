package com.example.storemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ObjectUtils;

@SpringBootApplication
public class StoreManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreManagerApplication.class, args);
//
//        Cashier cashier = new Cashier(1, "John");
//
//        double totalPrice = cashier.calculateTotal(products);
//
//        System.out.println(totalPrice);
//
//        System.out.println(cashier.receipt(products));

        Store.addProduct("src/main/resources/products.csv");

        for (Product product : Store.products.keySet()) {
            System.out.println(product);
        }
    }

}
