package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.utils.Status;

public class SiteOfLostGrace extends Ground {

    public SiteOfLostGrace() {
        super('U');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }

}
