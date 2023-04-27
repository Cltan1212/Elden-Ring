package game.actions.actorActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.reset.ResetManager;
import game.runes.Runes;
import game.utils.FancyMessage;
import game.utils.Status;


public class ResetAction extends Action {
    private Location lastLocation;

    private Location siteOfLostGrace;

    public ResetAction(Location siteOfLostGrace, Location lastLocation){
        this.siteOfLostGrace = siteOfLostGrace;
        this.lastLocation = lastLocation;
    }

    public ResetAction(){
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        ResetManager.getInstance().run();

        if(!actor.hasCapability(Status.RESTING)){
            result = FancyMessage.YOU_DIED;
            map.moveActor(actor, siteOfLostGrace);
            lastLocation.addItem(new Runes(actor));
        }
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
