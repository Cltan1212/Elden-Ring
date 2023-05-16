package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import game.actions.runesActions.SellAction;

/**
 * An interface for creating different type of sell actions.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 */
public interface Sellable {

    void createSellAction(Actor actor, Integer price);
}
