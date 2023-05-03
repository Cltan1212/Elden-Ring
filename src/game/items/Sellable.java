package game.items;

import game.actions.runesActions.SellAction;

/**
 * An interface for creating different type of sell actions.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 */
public interface Sellable {

    /**
     *
     * @return the instance of {@link SellAction}
     */
    SellAction createSellAction();
}
