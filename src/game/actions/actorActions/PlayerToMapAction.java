package game.actions.actorActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * A class that represents player moving to a different map action
 * This action which be available if the player stands or get near to the GoldenFogDoor and selected to travel
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see Action
 */
public class PlayerToMapAction extends Action {

    public GameMap map;
    public Location newLocation;
    public String newMapName;

    /**
     * Constructor
     * @param map the map in which the player wants to move to
     * @param location the location the player will land on
     * @param mapName the name of the destination map
     */
    public PlayerToMapAction(GameMap map, Location location, String mapName) {
        this.map = map;
        newLocation = location;
        newMapName = mapName;
    }

    /**
     * Execute the PlayerToMapAction
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string describing the outcome of the action.
     * @see MoveActorAction
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Action moveAction = new MoveActorAction(newLocation,"");
        moveAction.execute(actor, this.map);
        return menuDescription(actor);
    }

    /**
     * Return a string describing this action in the menu.
     *
     * @param actor The {@link Actor} performing the action.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " travels to " + newMapName;
    }
}
