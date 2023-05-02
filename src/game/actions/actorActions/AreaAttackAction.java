package game.actions.actorActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.utils.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A class that represents an area attack action, which allows the actor to attack any adjacent actors with a given weapon.
 * @see Action
 */
public class AreaAttackAction extends Action {

    /**
     * {@link Weapon} used for the attack
     */
    private Weapon weapon;

    /**
     * Constructor.
     *
     * @param weapon the {@link Weapon} used for the attack.
     */
    public AreaAttackAction(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Executes the area attack action by attacking any adjacent actors with the given weapon.
     *
     * @param actor The {@link Actor} performing the action.
     * @param map The {@link GameMap} the {@link Actor} is on.
     * @return a String describing the result of the action.
     * @see AttackAction
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = actor + " attacks their surrounding!";

        Location actorLocation = map.locationOf(actor);

        for (Exit exit : actorLocation.getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()){
                result += "\n" + new AttackAction(destination.getActor(), destination.toString(), this.weapon).execute(actor, map) + "\n";
            }
        }
        return result;
    }

    /**
     * Returns a description of the area attack action to be displayed in the game menu.
     *
     * @param actor The {@link Actor} performing the action.
     * @return a String describing the area attack action.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks anything in the surrounding with " + this.weapon;
    }
}
