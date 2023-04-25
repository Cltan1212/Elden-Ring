package game.items;

import game.actions.runesActions.SellAction;

public interface Sellable {

    public SellAction createSellAction();
}
