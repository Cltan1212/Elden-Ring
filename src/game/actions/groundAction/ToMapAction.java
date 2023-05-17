package game.actions.groundAction;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class ToMapAction extends Action {

    GameMap newLocation;
    int x, y;

    public ToMapAction(GameMap newLocation, int x, int y) {
        this.newLocation = newLocation;
        this.x = x;
        this.y = y;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Action moveAction = new MoveActorAction(newLocation.at(this.x, this.y),"");
        moveAction.execute(actor, newLocation);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
