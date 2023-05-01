package game.items;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Interface for consumable items in the game.
 */
public interface Consumable {
    /**
     * Consumes the item by the given actor.
     *
     * @param actor the actor consuming the item
     */
    void consume(Actor actor);
}
