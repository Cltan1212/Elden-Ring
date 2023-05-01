package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.actorActions.AttackAction;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

/**
 * A class that represents the behaviour of attacking a target. This class implements the Behaviour interface
 * and defines the getAction method, which returns an AttackAction if there are hostile actors within the
 * GameMap or if there is a designated target. If there is no target, this class returns null.
 */
public class AttackBehaviour implements Behaviour {

    private Actor target;

    /**
     * Constructor.
     *
     * @param target the target actor that this behaviour should attack
     */
    public AttackBehaviour(Actor target){
        this.target = target;
    }

    /**
     * Returns an AttackAction if there are hostile actors within the GameMap or if there is a designated target.
     * If there is no target, this method returns null.
     *
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        Location here = map.locationOf(actor); // get location of current actor
        String direction = "";
        int numEnemies = 0;

        // iterate through all actor's exists (8 locations)
        for (Exit exit : here.getExits()) {

            // since enemy can't attack their own type, we attack the target
            if (exit.getDestination().getActor() == target) {
                direction = exit.toString();
            }

            // check if an exit contains an actor that is hostile to enemy
            if (exit.getDestination().containsAnActor() && exit.getDestination().getActor().hasCapability(Status.HOSTILE_TO_ENEMY)) {
                numEnemies++;
                target = exit.getDestination().getActor();
                direction = exit.toString();
            }
            else if (exit.getDestination().containsAnActor()){
                numEnemies++;
            }
        }

        if (numEnemies != 0) {
            if (!actor.getWeaponInventory().isEmpty()) { // enemy have special skill
                if (RandomNumberGenerator.getRandomInt(100) < 50) { // enemy have 50% chance to perform special skill
                    return actor.getWeaponInventory().get(0).getSkill(actor);
                }
                else {
                    return actor.getWeaponInventory().get(0).getSkill(target, direction);
                }
            }  // use their intrinsic weapon
            return new AttackAction(target, direction);
        }
        return null;
    }
}
