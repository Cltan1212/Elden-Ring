package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.Status;

public class CurvedSword extends WeaponItem {


    /**
     * Constructor.
     *
     * @param name        name of the item
     * @param displayChar character to use for display when item is on the ground
     * @param damage      amount of damage this weapon does
     * @param verb        verb to use for this weapon, e.g. "hits", "zaps"
     * @param hitRate     the probability/chance to hit the target.
     */
    public CurvedSword(String name, char displayChar, int damage, String verb, int hitRate) {
        super(name, displayChar, damage, verb, hitRate);

        // if an instance of the CurvedSword class is stored in the player's inventory,
        // then the player will also own this capability
        this.addCapability(Status.SPINNING_ATTACK);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}
}
