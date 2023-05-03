package game.items;

import game.actions.runesActions.PurchaseAction;

/**
 * An interface for creating different type of purchase action.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 */
public interface Purchasable {

    /**
     *
     * @return the instance of {@link PurchaseAction}
     */
    PurchaseAction createPurchaseAction();
}
