package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Trader;

/**
 * Action for selling a weapon to a Trader
 */
public class SellAction extends Action {

    private String weaponName; // Name of the weapon to sell
    private Trader trader; // reference to the trader object

    public SellAction(String weaponName, Trader trader){
        this.weaponName = weaponName;
        this.trader = trader;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        // Implement logic for selling weapon to the Trader
        // using the actor, map, weaponName, and trader objects
        // Return a description of what happened
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        // Implement logic for generating menu description
        // using the actor object
        // Return the text to display on the menu
        return actor.getDisplayChar() + "has sold " + this.weaponName;
//        return null;
    }

}
