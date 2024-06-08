package org.vendingmachine.states;

import org.vendingmachine.Denomination;

public interface State
{
    StatesEnum selectProduct(String sku);
    StatesEnum collectMoney(Denomination d, int q);

    StatesEnum dispatch(String sku);

    StatesEnum display();

}
