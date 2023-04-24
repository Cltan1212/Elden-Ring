package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.actorActions.DespawnedAction;

public class DespawnedBehaviour implements Behaviour{
    @Override
    public Action getAction(Actor actor, GameMap map) {
        return new DespawnedAction();
    }
}
