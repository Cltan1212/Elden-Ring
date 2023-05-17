package game.items.trading;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Interface for consumable items in the game.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 */
public interface Consumable {
    /**
     * Consumes the item by the given actor.
     *
     * @param actor the {@link Actor} consuming the item
     */
    void consume(Actor actor);
}
