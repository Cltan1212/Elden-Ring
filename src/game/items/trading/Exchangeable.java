package game.items.trading;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * Interface for exchanging weaponItem in the game.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 */
public interface Exchangeable {

    /**
     *
     * @param actor The actor perform the exchange action
     * @param receiveItem The item that received by the actor
     */
    void createExchangeAction(Actor actor, WeaponItem receiveItem);
}
