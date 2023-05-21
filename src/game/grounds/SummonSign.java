package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.actorActions.AllyInvaderSpawnAction;
import game.utils.Status;

/**
 * SummonSign
 * The SummonSign class is one of the ground in this game
 * It extends Ground class
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 * @see Ground
 */
public class SummonSign extends Ground {
    // intentionally summon them rather than automatically spawning

    /**
     * Constructor of Summon Sign
     */
    public SummonSign() {
        super('=');
    }

    /**
     * This method allows adds {@link AllyInvaderSpawnAction} as one of the allowable action for to player to choose from
     * when landing on the SummonSign ground
     * @param actor the {@link Actor}Actor acting
     * @param location the current {@link Location}
     * @param direction the direction of the Ground from the {@link Actor}
     * @return a collection of actions
     * @see AllyInvaderSpawnAction
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AllyInvaderSpawnAction());
        }
        return actions;
    }

    /**
     * This method serve to check if an actor can enter the ground
     * @param actor the {@link Actor} to check
     * @return boolean, true if it can enter, false otherwise
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);  // actor can step on summon sign
    }
}
