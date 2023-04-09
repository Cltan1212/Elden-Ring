package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

public class SiteOfLostGrace extends Ground {

    public SiteOfLostGrace() {
        super('U');
    }

    @Override
    public boolean canActorEnter(Actor actor){
        // TODO: only the actor have capabilities resting allow to enter
        return false;
    }
}
