package game.actions.traderActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.trading.Sellable;

/**
 * A class that represents an action of selling a {@link WeaponItem} object to get runes
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see Action
 */
public class SellAction extends Action {
    private Sellable sellableItem;

    private final int price;

    /**
     * Constructor.
     *
     * @param sellableWeaponItem a {@link WeaponItem} object that is going to be sold
     * @param price the price of the item in runes
     */
    public SellAction(Sellable sellableWeaponItem, int price){
        this.sellableItem = sellableWeaponItem;
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

        sellableItem.createSellAction(actor, price);

        // print the status
        message = actor + " successfully sold " + sellableItem;

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
        return actor + " sell " + sellableItem + " with $" + price;
    }
}
