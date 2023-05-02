package game.reset;

import edu.monash.fit2099.engine.positions.GameMap;
import game.grounds.SiteOfLostGrace;

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
    /**
     * A list of {@link Resettable} objects to be reset.
     */
    private List<Resettable> resettables;

    /**
     * A list of {@link GameMap} objects that the reset manager can reset.
     */
    private List<GameMap> allMap;

    /**
     * The last visited instance of {@link SiteOfLostGrace}.
     */
    private SiteOfLostGrace lastSiteOfLostGrace;

    /**
     * The instance of the ResetManager class.
     */
    private static ResetManager instance;

    /**
     * Private constructor of ResetManager
     */
    private ResetManager() {
        this.resettables = new ArrayList<>();
        this.allMap = new ArrayList<>();
    }

    /**
     * Returns the instance of ResetManager.
     * If there is no existing instance, a new instance is created.
     *
     * @return The instance of ResetManager/
     */
    public static ResetManager getInstance(){
        if (instance == null)
            instance = new ResetManager();
        return instance;
    }

    /**
     * Adds the last visited instance of {@link SiteOfLostGrace} to the reset manager.
     *
     * @param siteOfLostGrace The last visited instance of {@link SiteOfLostGrace}.
     */
    public void addSiteOfLostGrace(SiteOfLostGrace siteOfLostGrace){
        lastSiteOfLostGrace = siteOfLostGrace;
    }

    /**
     * Returns the last visited instance of {@link SiteOfLostGrace}
     * @return The last visited instance of {@link SiteOfLostGrace}.
     */
    public SiteOfLostGrace getLastVisited(){
        return lastSiteOfLostGrace;
    }

    /**
     * Adds a {@link GameMap} object to the reset manager's list of maps to reset.
     *
     * @param map The {@link GameMap} object to add.
     */
    public void addMap(GameMap map){
        allMap.add(map);
    }

    /**
     * Resets all objects that implement the {@link Resettable} interface in all the maps in the reset manager's list.
     */
    public void run() {
        for (GameMap map : allMap){
            for (Resettable resettable: resettables){
                resettable.reset(map);
            }
        }
    }

    /**
     *  Adds a {@link Resettable} object to the reset manager's list of objects to reset.
     *
     * @param resettable The {@link Resettable} object to add.
     */
    public void registerResettable(Resettable resettable) {
        resettables.add(resettable);
    }

    /**
     * Removes a {@link Resettable} object from the reset manager's list of objects to reset.
     * @param resettable The {@link Resettable} object to remove.
     */
    public void removeResettable(Resettable resettable) {
        resettables.remove(resettable);
    }
}