package org.vendingmachine;

public class Denomination {
    enum Type {
        RUPEES_4,
        RUPEES_3,
        RUPEES_1000,
        RUPEES_5,
    }

    Type type;
    int val;
    public Denomination(Type type, int val) {
        this.type = type;
        this.val = val;
    }

}
