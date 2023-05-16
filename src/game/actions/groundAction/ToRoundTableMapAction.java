package game.actions.groundAction;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class ToRoundTableMapAction extends Action {


    GameMap newLocation;
    public ToRoundTableMapAction(GameMap map) {
        newLocation = map;  // the map to travel to
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Action moveAction = new MoveActorAction(newLocation.at(9, 10),"");
        moveAction.execute(actor, newLocation);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " travels to Roundtable Hold";
    }
}
