package game.behaviour;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class AttackBehaviour implements Behaviour {

    // Guessing Purpose of this class: Enemies attack player???
    private final Actor targetAttack;
    public AttackBehaviour(Actor targetAttack) {
        this.targetAttack = targetAttack;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        // this method should return a target Action for the actor to attack


        // Check if target and actor are present in map
        // if either not present, return null -> no action performed
        // else iterates over the location near, and check if there is any actor
        // having capability Status.HOSTILE_TO_ENEMY
        // if contains, then create an attack else null -> no action performed
            // return new xxAction();
        // else
        return null;
    }
}
