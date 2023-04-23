package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class DespawnedBehaviour implements Behaviour{
    @Override
    public Action getAction(Actor actor, GameMap map) {
        return null;
    }

    // HeavySkeletalSwordsman, LoneWolf and GiantCrabs have 10% chance of being
    // despawned from the map unless following the player.

}
