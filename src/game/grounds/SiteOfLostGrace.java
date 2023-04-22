package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.Status;

public class SiteOfLostGrace extends Ground {

    // allow player to rest on it, when this happens, the entire game will be reset

    public SiteOfLostGrace() {
        super('U');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }

    // BELOW needs to be add when rest action method is implemented

//    public ActionList allowableActions(Actor actor, Location location, String direction){
//        ActionList actions = new ActionList();
//        if (actor.hasCapability(Status.RESTING)){
////            actions.add(new RestAction(this, ))     WILL NEED TO DEPEND ON RESTACTION METHOD
//
//        }
//        return actions;
//
//    }

}
