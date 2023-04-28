package com.example.storemanager;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Store {
    static HashMap<Product, Integer> products = new HashMap<>();

    public LocalDate stringToDate(String date) {
        String[] dateArray = date.split("/");
        int day = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int year = Integer.parseInt(dateArray[2]);
        return LocalDate.of(year, month, day);
    }

    public static LocalDate stringToLocalDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        return LocalDate.parse(dateString, formatter);
    }

    public static void addProduct(String fileName) {

        String line = "";
        String splitBy = ",";
        try {
            //parsing a CSV file into BufferedReader class constructor
            File file = new File(fileName);

            FileReader fr = new FileReader(file);

            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null)   //returns a Boolean value // "1,Dano Milk,Beverage,100,500,4/4/2024"

            // String[] product = new String[]{"1","Dano Milk","Beverage","100","500","4/4/2024"};
            {
                String[] product = line.split(splitBy);    // use comma as separator

                Product newProduct = new Product(Integer.parseInt(product[0]), product[1], product[2], Double.parseDouble(product[3]), stringToLocalDate(product[5]));

                products.put(newProduct, Integer.parseInt(product[4]));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
