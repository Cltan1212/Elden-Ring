package game.items;

import game.actions.runesActions.PurchaseAction;

public interface Purchasable {

    public PurchaseAction createPurchaseAction();
}
