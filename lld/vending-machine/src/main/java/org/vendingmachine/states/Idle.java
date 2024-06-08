package org.vendingmachine.states;

import org.vendingmachine.Denomination;
import org.vendingmachine.Inventory;

public class Idle implements State {
    Inventory inventory;
    public Idle(Inventory inventory) {
        this.inventory = inventory;
    }
    @Override
    public StatesEnum selectProduct(String sku) {
        System.out.println("Product selected: " + sku);
        return StatesEnum.SELECTED;
    }

    @Override
    public StatesEnum collectMoney(Denomination d, int q) {
        System.out.println("Please selected a product first ");
        return StatesEnum.STATE_UNSPECIFIED;
    }

    @Override
    public StatesEnum dispatch(String sku) {
        System.out.println("Please selected a product first ");
        return StatesEnum.STATE_UNSPECIFIED;
    }

    @Override
    public StatesEnum display() {
        inventory.displayProducts();
        return StatesEnum.STATE_UNSPECIFIED;
    }
}
