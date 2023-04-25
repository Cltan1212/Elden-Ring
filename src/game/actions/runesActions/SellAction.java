package game.actions.runesActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.runes.RunesManager;

public class SellAction extends Action {
    private final WeaponItem sellableItem;

    private final int price;
    public SellAction(WeaponItem sellableItem, int price){
        this.sellableItem = sellableItem;
        this.price = price;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String message = "";

        // remove the weapon from inventory
        WeaponItem removeWeapon = null;
        for (WeaponItem weaponItem: actor.getWeaponInventory()){
            if (weaponItem.toString().equals(sellableItem.toString())){
                removeWeapon = weaponItem;
            }
        }
        actor.removeWeaponFromInventory(removeWeapon);
        map.locationOf(actor).removeItem(removeWeapon);

        // add runes to player
        RunesManager.getInstance().addRunes(actor,price);

        // print the status
        message = actor + " successfully sold " + sellableItem.toString();

        return message;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " sell " + sellableItem.toString() + " with $" + price;
    }
}
