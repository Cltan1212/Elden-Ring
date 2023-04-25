package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.actorActions.AttackAction;
import game.utils.Status;

/**
 * A class that automatically calls AttackAction on the actor's surroundings if there is another actor
 */
public class AttackBehaviour implements Behaviour {

    // Purpose of this class: Enemies attack player???
    private final Actor targetAttack;
    public AttackBehaviour(Actor targetAttack){
        this.targetAttack = targetAttack;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        // this method should return a target Action for the actor to attack

        // check if target and actor are present in map
        // if either not present, return null -> no action performed
        // else iterates over the location near, and check if there is any actor
        // having capability Status.HOSTILE_TO_ENEMY
        // if contains, then create an attack else null -> no action performed
        // return new xxAction();
        // else
        if (!map.contains(actor) || !map.contains(targetAttack)){
            return null;
        }

        // LOOK for enemies around actor
        // if more then one enemy -> AreaAttackAction (constructor of AreaAttackAction take in list of enemies to attack)
        // which loop through the list and attack each of them
        // if only one enemy -> AttackAction

        // maybe can have a specialAttack in giantCrab and heavyskeletal, so if != null, can perform AreaAttackAction



        Location here = map.locationOf(actor); // get location of current actor

        // iterate through all actor's exists (8 locations)
        for (Exit exit: here.getExits()){
            // check if an exit contains an actor that is hostile to enemy
            if (exit.getDestination().containsAnActor() && exit.getDestination().getActor().hasCapability(Status.HOSTILE_TO_ENEMY)){
                String direction = exit.getName();
                return new AttackAction(exit.getDestination().getActor(), direction); // current actor calls AttackAction on the other actor
            }
        }

        return null; // if no action is called

    }
}
