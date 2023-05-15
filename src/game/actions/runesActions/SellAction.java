package game.actions.runesActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.runes.RunesManager;

/**
 * A class that represents an action of selling a {@link WeaponItem} object to get runes
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see Action
 */
public class SellAction extends Action {
    private WeaponItem sellableWeaponItem = null;

    private Item sellableItem = null;

    private final int price;

    /**
     * Constructor.
     *
     * @param sellableWeaponItem a {@link WeaponItem} object that is going to be sold
     * @param price the price of the item in runes
     */
    public SellAction(WeaponItem sellableWeaponItem, int price){
        this.sellableWeaponItem = sellableWeaponItem;
        this.price = price;
    }

    public SellAction(Item item, int price){
        this.sellableItem = item;
        this.price = price;
    }

    /**
     * Remove the {@link WeaponItem} object from the actor's inventory and the game map, and add the sell price into
     * the actor's inventory.
     *
     * @param actor The {@link Actor} performing the action.
     * @param map The {@link GameMap} the actor is on.
     * @return a string describing the result of the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String message = "";

        // remove the weapon from inventory
        WeaponItem removeWeapon = null;
        for (WeaponItem weaponItem: actor.getWeaponInventory()){
            if (weaponItem.toString().equals(sellableWeaponItem.toString())){
                removeWeapon = weaponItem;
            }
        }
        actor.removeWeaponFromInventory(removeWeapon);
        map.locationOf(actor).removeItem(removeWeapon);

        // add runes to player
        RunesManager.getInstance().addRunes(actor,price);

        // print the status
        message = actor + " successfully sold " + sellableWeaponItem.toString();

        return message;
    }

    /**
     * Returns a string describing the action that will be displayed in the menu.
     *
     * @param actor The {@link Actor} performing the action.
     * @return a string describing the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " sell " + sellableWeaponItem.toString() + " with $" + price;
    }
}
