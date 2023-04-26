package game.actions.actorActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.utils.Status;

import java.awt.*;

public class RestAction extends Action {

    private String siteOfLostGrace;
    public RestAction(String siteOfLostGrace){
        this.siteOfLostGrace = siteOfLostGrace;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        actor.addCapability(Status.RESTING);
        new ResetAction().execute(actor, map);
        actor.removeCapability(Status.RESTING);
        return actor + " rested at " + siteOfLostGrace;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " rests at " + siteOfLostGrace;
    }


}
