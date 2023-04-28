package com.example.storemanager;

import lombok.Data;

@Data
public class Cashier {
    private int id;
    private String name;

    public Cashier() {
    }
    public Cashier(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public double calculateTotal(Product[] products) {
        double total = 0;
//        for (Products product : products) {
//            total += product.getPrice();
//        }
        for (int i = 0; i < products.length; i++) {
            if(products[i] != null){
                total += products[i].getPrice();
            }
        }
        return total;
    }

    public String receipt(Product[] products) {
        String receipt = "";
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                receipt += products[i].getName() + " .... " + products[i].getPrice() + "\n";
            }
        }
        receipt += "\nTotal: " + calculateTotal(products);
        return receipt;
    }
}
