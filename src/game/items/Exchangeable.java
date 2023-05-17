package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public interface Exchangeable {

    void createExchangeAction(Actor actor, WeaponItem receiveItem);
}
