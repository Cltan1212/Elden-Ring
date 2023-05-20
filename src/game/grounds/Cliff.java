package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.actorActions.attackActions.DeathAction;
import game.utils.Status;

/**
 * Cliff
 * The Cliff class is one of the ground in this game
 * It extends Ground class
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 * @see Ground
 */
public class Cliff extends Ground {
    /**
     * Constructor
     */
    public Cliff() {
        super('+');
    }

    /**
     * This method serve to check if an actor can enter the ground
     * @param actor the {@link Actor} to check
     * @return boolean, true if it can enter, false otherwise
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        // only player can step on it
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }

    /**
     * Ground can also experience the joy of time.
     * This method will result in a checking if the actor on the Cliff is a player
     * If it has the Status Hostile_TO_ENEMY, it will immediately falls off the cliff and die
     * @param location The location {@link Location} of the Ground
     * @see DeathAction
     */
    public void tick(Location location) {
        if (location.containsAnActor()){
            Actor actor = location.getActor();
            if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                Display display = new Display();
                display.println(actor + " falls off the cliff");
                display.println(new DeathAction().execute(actor, location.map()));
            }
        }
    }

}
