package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class StarscourgeHeirloom extends ConsumableItem implements Sellable{
    /**
     * Constructor.
     *
     */
    public StarscourgeHeirloom() {
        super("Starscourge Heirloom",'l', true);
    }

    @Override
    public void consume(Actor actor) {
        for (WeaponItem weaponItem: actor.getWeaponInventory()){

        }
    }

    @Override
    public void createSellAction(Actor actor, Integer price) {

    }
}
