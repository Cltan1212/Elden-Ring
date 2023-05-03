package game.runes;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class representing to manage all the runes inside the system.
 * This class manage to add, deduct, transfer and get runes in the game world.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 */
public class RunesManager {

    /**
     * The instance of Runes Manager
     */
    private static RunesManager instance;

    /**
     * A list that contains all the RuneSource.
     * While RuneSource represent the ability of generating runes.
     */
    private List<RuneSource> runeSourceList;

    /**
     * A HashMap that manage all the actor and its corresponding runes amount.
     * This HashMap is act like a wallet for each actor but managed by the RunesManager.
     */
    private Map<Actor, Integer> runesHeld;

    /**
     * Constructor.
     */
    private RunesManager(){
        this.runeSourceList = new ArrayList<>();
        this.runesHeld = new HashMap<>();
    }

    /**
     * Accessor for the current RunesManager instance.
     *
     * @return current RunesManager instance
     */
    public static RunesManager getInstance(){
        if (instance == null){
            instance = new RunesManager();
        }
        return instance;
    }

    /**
     * Register all the {@link RuneSource} in the game world.
     *
     * @param runeSource the ability of generating runes.
     */
    public void registerRuneSource(RuneSource runeSource){
        runeSourceList.add(runeSource);
    }

    /**
     * Remove the {@link RuneSource} in the game world.
     *
     * @param runeSource the ability of generating runes.
     */
    public void removeRuneSource(RuneSource runeSource){
        runeSourceList.remove(runeSource);
    }

    /**
     * Find the corresponding {@link RuneSource} for this actor.
     *
     * @param actor the {@link Actor} have this ability of generating {@link RuneSource}
     * @return the corresponding {@link RuneSource} of this actor.
     */
    private RuneSource findRuneSource(Actor actor){
        for (RuneSource runeSource : runeSourceList){
            if (actor == runeSource){
                return runeSource;
            }
        }
        return null;
    }

    /**
     * Register all the runeHolder and the amount in the game world.
     *
     * @param runeHolder the {@link Actor} who holds the current runes
     * @param amount the current amount where the {@link Actor} holds
     */
    public void registerRunesHeld(Actor runeHolder, int amount){
        runesHeld.put(runeHolder, amount);
    }

    /**
     * Transfer the runes amount from the enemy to the runeHolder.
     *
     * @param Enemy the death enemy that drop the runes
     * @param runeHolder attacker of the enemy
     * @return the amount of the total runes transfer
     */
    public int transferRunes(Actor Enemy, Actor runeHolder){
        RuneSource runeSource = findRuneSource(Enemy);
        Integer currentRunesHeld = runesHeld.get(runeHolder);
        if (runeSource != null && currentRunesHeld != null){
            int transferredRunes = runeSource.generateRunes();
            int updatedRunesHeld = currentRunesHeld + transferredRunes;
            runesHeld.put(runeHolder, updatedRunesHeld);
            runeSourceList.remove(runeSource);
            return transferredRunes;
        }
        return 0;
    }

    /**
     * Deduct the specific amount of runes from runeHolder.
     *
     * @param runeHolder the {@link Actor} that hold the runes.
     * @param amount the amount that needed to be deducted.
     */
    public void deductRunes(Actor runeHolder, int amount){
        Integer currentRunesHeld = runesHeld.get(runeHolder);
        if (currentRunesHeld != null){
            int updateRunesHeld = currentRunesHeld - amount;
            runesHeld.put(runeHolder, updateRunesHeld);
        }
    }

    /**
     * Add the specific amount of runes to runeHolder.
     *
     * @param runeHolder the {@link Actor} that hold the runes.
     * @param amount the amount that needed to be added.
     */
    public void addRunes(Actor runeHolder, int amount){
        Integer currentRunesHeld = runesHeld.get(runeHolder);
        if (currentRunesHeld != null){
            int updateRunesHeld = currentRunesHeld + amount;
            runesHeld.put(runeHolder, updateRunesHeld);
        }
    }

    /**
     *  Accessor of the runes amount of an runesHolder.
     *
     * @param runeHolder the {@link Actor} who holds the runes.
     * @return the amount that the runeHolder holds.
     */
    public int getRunes(Actor runeHolder){
        return runesHeld.get(runeHolder);
    }

}
