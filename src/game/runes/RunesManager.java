package game.runes;

import edu.monash.fit2099.engine.items.Item;
import game.actors.Player;
import game.utils.Status;

public class RunesManager {
    private static Player player;

    public static void setPlayer(Player player){
        RunesManager.player = player;
    }

    public static void addRunesValue(int values){
        RunesManager.player.runesItem.addRunes(values);
    }

    public static void subtractRunesValue(int values){
        RunesManager.player.runesItem.subtractRunes(values);
    }

    public static int getRunesValue(){
        return RunesManager.player.runesItem.getRunesValue();
    }


}
