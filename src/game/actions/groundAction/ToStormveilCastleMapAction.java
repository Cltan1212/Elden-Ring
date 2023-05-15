package game.actions.groundAction;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class ToStormveilCastleMapAction extends Action {

    GameMap newLocation;
    public ToStormveilCastleMapAction(GameMap map) {
        newLocation = map;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        // moves the player to the map

        Action moveAction = new MoveActorAction(newLocation.at(9, 10),"");
        moveAction.execute(actor, newLocation);
        return menuDescription(actor);
    }



    @Override
    public String menuDescription(Actor actor) {
        return actor + " travels to Stormveil Castle";
    }
}
