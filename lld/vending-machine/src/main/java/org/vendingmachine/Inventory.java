package org.vendingmachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Inventory {

    // sku to quantity
    Map<String, Integer> stock = new ConcurrentHashMap<>();

    // sku to product
    Map<String, Product> products = new ConcurrentHashMap<>();
    public void addNewProduct(Product p) {
        products.putIfAbsent(p.sku, p);
        stock.putIfAbsent(p.sku, 0);
    }

    public  Product getInfo(String sku) {
        return products.get(sku);
    }
    public void addStock(String sku, int q) {
        if(!stock.containsKey(sku)){
            System.out.println("Product not supported: " + sku);
        }
        stock.put(sku, stock.get(sku) + q);
    }

    public void getProduct(String sku) {
        if(!stock.containsKey(sku))
            {
            System.out.println("Product not supported: "+ sku);
        }
        else if(stock.get(sku)== 0) {
            System.out.println("Product is out of stock: " +sku);
        }
         else {
            stock.put(sku, stock.get(sku) - 1);
        }
    }

    public List<Product> displayProducts() {
        return products.values().stream().map(p -> {
            System.out.printf("Product: %s, Quantity: %d\n", p.name, stock.get(p.sku));
            return p;
        }).collect(Collectors.toList());
    }

}
