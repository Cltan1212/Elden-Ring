package game.reset;

import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Coordinates the reset process and manages the resetting of different game elements
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class ResetManager {
    private List<Resettable> resettables;
    private List<GameMap> maps;
    private static ResetManager instance; // to ensure that only one instance of ResetManager can exist

    /**
     * HINT 1: where have we seen a private constructor before?
     * HINT 2: see the instance attribute above.
     */
    private ResetManager() {
        this.resettables = new ArrayList<>();
        this.maps = new ArrayList<>();

    }

    public static ResetManager getInstance(){  // referring to Bootcamp week 5
        if (instance == null){
            instance = new ResetManager();
        }
        return instance;
    }

    public void run() {
        // iterates through the list resettables and calls the reset() method on each of them
        // trigger the Resettable object and reset() method of each Resettable object will be executed
        // so they reset their state to their initial values
        // so can coordinate and manage the resetting of multiple game objects or components

        for (Resettable resettable: resettables){
            for (GameMap map: maps) {
                resettable.reset(map);
            }
        }
    }

    public void registerResettable(Resettable resettable) {
        resettables.add(resettable);
    }

    public void removeResettable(Resettable resettable) {
        resettables.remove(resettable);
    }

    public List<GameMap> getMaps() {
        return maps;
    }

    public void setMaps(List<GameMap> maps) {
        this.maps = maps;
    }

    public void addMap(GameMap map){
        maps.add(map);
    }
}
