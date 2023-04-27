package game.actions.actorActions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class DespawnedAction extends Action {

    // HeavySkeletalSwordsman, LoneWolf and GiantCrabs have 10% chance of being
    // despawned from the map unless following the player.

    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " has been removed from the map";
    }

}
