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
        Location lastSite = map.at(ResetManager.getInstance().getLastVisited().locationX, ResetManager.getInstance().getLastVisited().locationY);
        String result = "";
        Runes runes = new Runes(actor, lastLocation);
        ResetManager.getInstance().run();
        if(!actor.hasCapability(Status.RESTING)){
            result = "\n" + FancyMessage.YOU_DIED;
            lastLocation.addItem(runes);
//            Location moveLocation = new Location(map, ResetManager.getInstance().getLastVisited().locationX,  ResetManager.getInstance().getLastVisited().locationY);
//            map.at(ResetManager.getInstance().getLastVisited().locationX, ResetManager.getInstance().getLastVisited().locationY).addActor(actor);
            map.moveActor(actor, lastSite);

        }

        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
