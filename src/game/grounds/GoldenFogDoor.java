package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.actorActions.PlayerToMapAction;
import game.utils.Status;

/**
 * GoldenFogDoor
 * The GoldenFogDoor class is one of the ground in this game
 * It extends Ground class
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 * @see Ground
 */

public class GoldenFogDoor extends Ground {
    /**
     * Represents door in the game in which allows the player to travel to different game map
     */

    public GameMap newMap;

    /**
     * the location on the game map in which the player will be landing on
     */
    public Location newLocation;

    /**
     * the name of the map (e.g. Limgrave/RoundTableHold/StormveilCastle)
     */
    public String newMapName;

    /**
     * Constructor
     * @param map the game map to travel to
     * @param location the location on the game map in which the player will be landing on
     * @param mapName the name of the map (e.g. Limgrave/RoundTableHold/StormveilCastle)
     */
    public GoldenFogDoor(GameMap map, Location location, String mapName) {
        super('D');
        newMap = map;
        newLocation = location;
        newMapName = mapName;
    }


    /**
     * This method allows adds {@link PlayerToMapAction} as one of the allowable action for to player to choose from
     * @param actor the {@link Actor}Actor acting
     * @param location the current {@link Location}
     * @param direction the direction of the Ground from the {@link Actor}
     * @return a collection of actions
     * @see PlayerToMapAction
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();

        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new PlayerToMapAction(newMap, newLocation, newMapName));
        }
        return actions;
    }

    /**
     * This method serve to check if an actor can enter the ground
     * @param actor the {@link Actor} to check
     * @return boolean, true if it can enter, false otherwise
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);  // only Player can step on GoldenFogDoor
    }
}