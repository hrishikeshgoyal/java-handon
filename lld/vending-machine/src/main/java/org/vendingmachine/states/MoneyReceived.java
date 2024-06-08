package org.vendingmachine.states;

import org.vendingmachine.Denomination;
import org.vendingmachine.Inventory;

public class MoneyReceived implements State {
    Inventory inventory;
    public MoneyReceived(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public StatesEnum selectProduct(String sku) {
        System.out.println("Product already selected, please collect your item");
        return StatesEnum.STATE_UNSPECIFIED;
    }

    @Override
    public StatesEnum collectMoney(Denomination d, int q) {
        System.out.println("Money already received, please collect your item");
        return StatesEnum.STATE_UNSPECIFIED;
    }

    @Override
    public StatesEnum dispatch(String sku) {
//        System.out.println("Dispatching started...");
        inventory.getProduct(sku);
//        System.out.println("item dispatched...");
        return StatesEnum.IDLE;
    }

    @Override
    public StatesEnum display() {
        System.out.println("Please collect your item first");
        return StatesEnum.STATE_UNSPECIFIED;
    }
}
