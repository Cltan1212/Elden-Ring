package game.runes;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actors.Player;
import game.actors.enemies.Enemy;
import game.utils.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RunesManager {

    private static RunesManager instance;

    private final List<RuneSource> runeSourceList;

    private final Map<Actor, Integer> runesHeld;

    private RunesManager(){
        this.runeSourceList = new ArrayList<>();
        this.runesHeld = new HashMap<>();
    }

    public static RunesManager getInstance(){
        if (instance == null){
            instance = new RunesManager();
        }
        return instance;
    }

    public void registerRuneSource(RuneSource runeSource){
        runeSourceList.add(runeSource);
    }

    public void removeRuneSource(RuneSource runeSource){
        runeSourceList.remove(runeSource);
    }

    private RuneSource findRuneSource(Actor actor){
        for (RuneSource runeSource : runeSourceList){
            if (actor == runeSource){
                return runeSource;
            }
        }
        return null;
    }

    public void registerRunesHeld(Actor runeHolder, int amount){
        runesHeld.put(runeHolder, amount);
    }

    public int transferRunes(RuneSource runeSource, Actor runeHolder){
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

    public void deductRunes(Actor runeHolder, int amount){
        Integer currentRunesHeld = runesHeld.get(runeHolder);
        if (currentRunesHeld != null){
            int updateRunesHeld = currentRunesHeld - amount;
            runesHeld.put(runeHolder, updateRunesHeld);
        }
    }

    public void addRunes(Actor runeHolder, int amount){
        Integer currentRunesHeld = runesHeld.get(runeHolder);
        if (currentRunesHeld != null){
            int updateRunesHeld = currentRunesHeld + amount;
            runesHeld.put(runeHolder, updateRunesHeld);
        }
    }

    public int getRunes(Actor runeHolder){
        return runesHeld.get(runeHolder);
    }

}
