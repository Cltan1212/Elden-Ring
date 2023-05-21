package game.actions.actorActions.attackActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.attackActions.AttackAction;
import game.utils.RandomNumberGenerator;
import game.weapons.combat.GreatKnife;

import java.util.ArrayList;
import java.util.List;

/**
 * QuickStepAction, the special skill of weapon GreatKnife
 * It extends Action class
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see Action
 * @see GreatKnife
 */
public class QuickStepAction extends Action {

    private Actor target;
    private WeaponItem weapon;
    private String direction;

    /**
     * Constructor
     * @param target the target enemy to attack
     * @param direction the direction in which the attack should be performed
     * @param weapon the {@link WeaponItem} performing the QuickStepAction
     */
    public QuickStepAction(Actor target, String direction, WeaponItem weapon){
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }

    /**
     * Perform the Quick Step Action.
     *
     * @param actor The {@link Actor} performing the action.
     * @param map The {@link GameMap} the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";

        result += new AttackAction(target, direction, weapon).execute(actor, map);

        // use move away from enemy, evading their attack, randomly pick a random location
        List<Location> emptyLocations = new ArrayList<Location>();
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor) && !destination.containsAnActor()) {
                emptyLocations.add(destination);
            }
        }

        // select a random position around the 8 location of the actor
        if (!emptyLocations.isEmpty()){
            Location newLocation = emptyLocations.get(RandomNumberGenerator.getRandomInt(emptyLocations.size()));
            map.moveActor(actor, newLocation);
            result += "\n" + actor + " moves to (" + newLocation.x() + ", " + newLocation.y() + ")";
        }
        return result;
    }

    /**
     /**
     * Returns a menu descriptive string
     * @param actor The {@link Actor} performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks (quick step) " + this.target + " and moves away";
    }
}
