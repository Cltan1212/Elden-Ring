package game.actions.runesActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.runes.RunesManager;

/**
 * A class that represents the action of purchasing a Purchasable item from a MerchantKale
 * @see Action
 */
public class PurchaseAction extends Action {

    private WeaponItem purchasableItem;
    private int price;

    /**
     * Constructor.
     *
     * @param purchasableItem the {@link WeaponItem} that is being purchased.
     * @param price  the price of the {@link WeaponItem}.
     */
    public PurchaseAction(WeaponItem purchasableItem, int price){
        this.purchasableItem = purchasableItem;
        this.price = price;
    }

    /**
     * Executes the action of purchasing a {@link WeaponItem}.
     *
     * @param actor The {@link Actor} performing the action.
     * @param map The {@link GameMap} the {@link Actor} is on.
     * @return a message describing the result of the action.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String message = "";

        if (RunesManager.getInstance().getRunes(actor) >= price){
            RunesManager.getInstance().deductRunes(actor,price);
            actor.addWeaponToInventory(purchasableItem);
            message = actor + " successfully purchase " + purchasableItem.toString();
        }
        else{
            message += actor + " do not have enough coins to buy " + purchasableItem.toString() + "!";
        }
        return  message;
    }

    /**
     * Returns a description of the action that can be displayed in the menu.
     *
     * @param actor The {@link Actor} performing the action.
     * @return a string describing the action.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " purchase " + purchasableItem.toString() + " with $" + price;
    }
}
