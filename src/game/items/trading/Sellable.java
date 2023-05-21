package game.items.trading;

import edu.monash.fit2099.engine.actors.Actor;
import game.actions.traderActions.SellAction;

/**
 * An interface for creating different type of sell actions.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 */
public interface Sellable {

    /**
     *
     * @param actor The actor perform sell action
     * @param price The price of the item
     */
    void createSellAction(Actor actor, Integer price);
}
