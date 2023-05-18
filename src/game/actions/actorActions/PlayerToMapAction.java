package game.actions.actorActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class PlayerToMapAction extends Action {

    GameMap map;
    Location newLocation;
//    String this_direction;

    String newMapName;

    public PlayerToMapAction(GameMap map, Location location, String mapName) {
        this.map = map;
        newLocation = location;
        newMapName = mapName;
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        Action moveAction = new MoveActorAction(newLocation,"");
        moveAction.execute(actor, this.map);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " travels to " + newMapName;
    }
}
