package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.actorActions.DespawnedAction;
import game.utils.RandomNumberGenerator;

public class DespawnedBehaviour implements Behaviour{

    private final int despawnChance = 10;
    @Override
    public Action getAction(Actor actor, GameMap map) {


        int randomNum = RandomNumberGenerator.getRandomInt(100);
        if (randomNum <= despawnChance){
            return new DespawnedAction();
        }
        return null;
    }

    // HeavySkeletalSwordsman, LoneWolf and GiantCrabs have 10% chance of being
    // despawned from the map unless following the player.

}
