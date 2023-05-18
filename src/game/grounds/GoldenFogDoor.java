package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.actorActions.PlayerToMapAction;
import game.utils.Status;

public class GoldenFogDoor extends Ground {
    /**
     * Constructor.
     */

    GameMap newMap;
    Location newLocation;
    String newMapName;
    public GoldenFogDoor(GameMap map, Location location, String mapName) {
        super('D');
        newMap = map;
        newLocation = location;
        newMapName = mapName;
    }


    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();

        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new PlayerToMapAction(newMap, newLocation, newMapName));
        }
        return actions;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);  // only Player can step on GoldenFogDoor
    }
}