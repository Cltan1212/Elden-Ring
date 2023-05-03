package game.actions.actorActions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * An action that removes an actor from the game map, typically used when the actor is despawned.
 * Actors with a certain condition (e.g. HeavySkeletalSwordsman, LoneWolf, and GiantCrabs) have a 10% chance of being
 * despawned from the map unless they are following the player.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see Action
 */
public class DespawnedAction extends Action {

    /**
     * Executes the action to remove the actor from the game map.
     *
     * @param actor The {@link Actor} performing the action.
     * @param map The {@link GameMap} the actor is on.
     * @return a string describing the result of the action.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return menuDescription(actor);
    }

    /**
     * Returns a string describing the action that will be displayed on the menu.
     *
     * @param actor The {@link Actor} performing the action.
     * @return a string describing the action that will be displayed on the menu.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " has been removed from the map";
    }

}
