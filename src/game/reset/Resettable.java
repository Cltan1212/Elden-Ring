package game.reset;

/**
 * A resettable interface
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public interface Resettable {
    void reset();

    default void registerInstance(){
        ResetManager.getInstance().registerResettable(this);
    }
}

