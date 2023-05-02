package game.reset;

import edu.monash.fit2099.engine.positions.GameMap;

/**
 * A resettable interface
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public interface Resettable {

    /**
     * Resets the object to its initial state on a given map.
     * @param map the map to reset the object on.
     */
    void reset(GameMap map);

    /**
     * Registers an instance of a resettable object with the reset manager.
     * This allows the object to be automatically reset when the reset manager runs.
     */
    default void registerInstance(){
        ResetManager.getInstance().registerResettable(this);
    }
}
