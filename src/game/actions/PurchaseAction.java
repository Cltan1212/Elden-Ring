package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.actors.Trader;
import game.runes.RunesManager;

public class PurchaseAction extends Action {

    private WeaponItem weapon; // Name of the weapon to purchase
    private int cost;
    private Trader trader; // Reference to the trader object

    public PurchaseAction(WeaponItem weapon, int cost, Trader trader){
        this.weapon = weapon;
        this.cost = cost;
        this.trader = trader;

    }

    /**
     * In this method, it checks whether the player inventory > cost of WeaponItem
     * If it does the weapon will be added to player's inventory or else an unsuccessful purchase attempt string
     * will be printed out
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        // Implement logic for buying weapon from the Trader
        // using the actor, map, weaponName, and trader objects
        // Return a description of what happened
        String returnMessage = "";
        if (actor.hasCapability(Status.BUYING) && RunesManager.getRunes() > cost){
            actor.addItemToInventory(weapon);
            RunesManager.deductRunes(cost);
            returnMessage = actor + " had bought " + weapon.getDisplayChar();

        }
        else{  // when not enough runes to buy weapon
            returnMessage = actor.getDisplayChar() + " do not have enough runes to buy " + weapon.getDisplayChar();

        }
        return returnMessage;
    }

    /**
     * This method display the menuDescription once they did a purchase
     * @param actor The actor performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        // Implement logic for generating menu description
        // using the actor object
        // Return the text to display on the menu
        return actor.getDisplayChar() + " had purchased " + this.weapon.getDisplayChar();
//        return null;
    }
}
