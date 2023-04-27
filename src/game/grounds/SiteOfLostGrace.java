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
    public int locationX;
    public int locationY;
    public SiteOfLostGrace(String name, int locationX, int locationY) {
        super('U');
        this.name = name;
        this.locationX = locationX;
        this.locationY = locationY;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }

    // BELOW needs to be add when rest action method is implemented

    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actions = new ActionList();
        if (actor.hasCapability(Status.RESTABLE)){
            actions.add(new RestAction(this));     //WILL NEED TO DEPEND ON RESTACTION METHOD
        }
        return actions;

    }

    @Override
    public String toString() {
        return this.name;
    }
}
