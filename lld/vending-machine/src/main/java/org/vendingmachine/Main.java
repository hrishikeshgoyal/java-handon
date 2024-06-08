package org.vendingmachine;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Inventory i = new Inventory();
        i.addNewProduct(new Product("Watch", 100));
//        i.addNewProduct(new Product("Specs", 5000));
//        i.addNewProduct(new Product("Robot", 50000));
//        i.addNewProduct(new Product("Toy", 3000));

        i.addStock("Watch", 100);
//        i.addStock("Specs", 100);
//        i.addStock("Robot", 100);
//        i.addStock("Toy", 100);

        Denomination d3 = new Denomination(Denomination.Type.RUPEES_3, 3);
        Denomination d4 = new Denomination(Denomination.Type.RUPEES_4, 4);
        Denomination d5 = new Denomination(Denomination.Type.RUPEES_5, 50);
        Denomination d1000 = new Denomination(Denomination.Type.RUPEES_1000, 10);

        Monetizer m = new Monetizer();

//        VendingMachine v = new VendingMachine(i, m);
        ExecutorService service = Executors.newFixedThreadPool(5);

        IntStream.range(0, 100).forEach(c -> service.submit(() -> run(i, m, d1000)));
        try {
            service.awaitTermination(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        i.displayProducts();
        m.showBalance();
    }

    static void run (Inventory i, Monetizer m, Denomination d) {

        VendingMachine v = new VendingMachine(i, m);
        v.selectProduct("Watch");
        v.collectMoney(d, 10);
//        v.display();
//        v.showBalance();
    }
}