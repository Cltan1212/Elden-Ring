package game.reset;

import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class ResetManager {
    private List<Resettable> resettables;

    private List<GameMap> allMap;
    private static ResetManager instance;


    /**
     * HINT 1: where have we seen a private constructor before?
     * HINT 2: see the instance attribute above.
     */

    public static ResetManager getInstance(){
        if (instance == null)
            instance = new ResetManager();
        return instance;
    }
    private ResetManager() {
        this.resettables = new ArrayList<>();
        this.allMap = new ArrayList<>();
    }

    public void addMap(GameMap map){
        allMap.add(map);
    }

    public void run() {
        for (GameMap map : allMap){
            for (Resettable resettable: resettables){
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

}
