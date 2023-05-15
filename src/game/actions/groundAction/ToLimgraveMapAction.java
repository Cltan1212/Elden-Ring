package game.actions.groundAction;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class ToLimgraveMapAction extends Action {


    GameMap newLocation;
    int x, y;

    public ToLimgraveMapAction(GameMap map, int xInput, int yInput) {
        newLocation = map;  // the map to travel to
        x = xInput;
        y = yInput;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Action moveAction = new MoveActorAction(newLocation.at(x, y), "");
        moveAction.execute(actor, newLocation);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " travels to Limgrave";
    }
}
