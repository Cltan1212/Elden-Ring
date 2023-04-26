package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.actorActions.RestAction;
import game.utils.Status;

public class SiteOfLostGrace extends Ground {

    // allow player to rest on it, when this happens, the entire game will be reset
    private String name;
    public SiteOfLostGrace(String name) {
        super('U');
        this.name = name;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }

    // BELOW needs to be add when rest action method is implemented

    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actions = new ActionList();
        if (actor.hasCapability(Status.RESTING)){
            actions.add(new RestAction(this.toString()));     //WILL NEED TO DEPEND ON RESTACTION METHOD
        }
        return actions;

    }

    @Override
    public String toString() {
        return this.name;
    }
}
