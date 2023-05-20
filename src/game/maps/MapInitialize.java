package game.maps;


import java.util.List;

/**
 * MapInitialize
 * The abstract class for initializing game map
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 * @see MapInitialize
 */

public abstract class MapInitialize {

    public List<String> map;

    /**
     * Constructor
     * for initializing the game map
     */
    public MapInitialize(List<String> map) {
        this.map = map;
    }

    /**
     * Getter for returning the map
     * @return the map
     */
    public List<String> getMap() {
        return map;
    }
}
