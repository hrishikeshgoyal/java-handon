package org.vendingmachine;

public class Product {
    public String name;
    public String sku;
    public int price;

    public Product(String n, int p) {
        name = n;
        price = p;
        sku = n;
    }


}
