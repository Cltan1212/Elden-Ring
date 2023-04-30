package game.items;

import game.actions.runesActions.PurchaseAction;

/**
 * An interface for creating different type of purchase action.
 *
 */
public interface Purchasable {

    /**
     *
     * @return the instance of Purchase Action
     */
    PurchaseAction createPurchaseAction();
}
