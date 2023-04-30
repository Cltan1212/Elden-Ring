package game.items;

import game.actions.runesActions.SellAction;

/**
 * An interface for creating different type of sell actions.
 *
 */
public interface Sellable {

    /**
     *
     * @return the instance of sell action
     */
    SellAction createSellAction();
}
