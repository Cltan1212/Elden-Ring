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

    public ResetAction(Location lastLocation){
        this.lastLocation = lastLocation;
    }

    public ResetAction(){
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        ResetManager.getInstance().run();

        if(!actor.hasCapability(Status.RESTING)){
            result = "\n" + FancyMessage.YOU_DIED;
            Location moveLocation = new Location(map, ResetManager.getInstance().getLastVisited().locationX,  ResetManager.getInstance().getLastVisited().locationY);
            map.moveActor(actor, moveLocation);
            lastLocation.addItem(new Runes(actor, lastLocation));
        }
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
