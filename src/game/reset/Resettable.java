package game.reset;

import edu.monash.fit2099.engine.positions.GameMap;

/**
 * A resettable interface
 * @author Adrian Kristanto
 * Modified by: Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 *
 */
public interface Resettable {

    /**
     * Resets the object to its initial state on a given map.
     * @param map the {@link GameMap} to reset the object on.
     */
    String reset(GameMap map);

    /**
     * Registers an instance of a resettable object with the {@link ResetManager}.
     * This allows the object to be automatically reset when the reset manager runs.
     */
    default void registerInstance(){
        ResetManager.getInstance().registerResettable(this);
    }
}
