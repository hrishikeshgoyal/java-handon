package org.vendingmachine.states;

import org.vendingmachine.Denomination;
import org.vendingmachine.Monetizer;

public class Selected implements State {
    private Monetizer monetizer;
    public Selected(Monetizer monetizer) {
        this.monetizer=monetizer;
    }
    @Override
    public StatesEnum selectProduct(String sku) {
        System.out.println("Product already selected, please pay");
        return StatesEnum.STATE_UNSPECIFIED;
    }

    @Override
    public StatesEnum collectMoney(Denomination d, int q) {
//        System.out.println("Depositing money...");
        monetizer.deposit(d, q);
//        System.out.println("Deposited money...");
        return StatesEnum.MONEY_RECEIVED;
    }

    @Override
    public StatesEnum dispatch(String sku) {
        System.out.println("Please pay first before requesting dispatch");
        return StatesEnum.STATE_UNSPECIFIED;
    }

    @Override
    public StatesEnum display() {
        System.out.println("Please pay first before display");
        return StatesEnum.STATE_UNSPECIFIED;
    }
}
