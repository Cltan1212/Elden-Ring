package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.actorActions.attackActions.DeathAction;
import game.utils.Status;

public class Cliff extends Ground {
    /**
     * Constructor.
     */
    public Cliff() {
        super('+');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        // only player can step on it
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }

    /**
     * Ground can also experience the joy of time.
     * @param location The location of the Ground
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
