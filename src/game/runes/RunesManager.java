package game.runes;

import game.actors.Player;

public abstract class RunesManager {
    private static Player player;

    public static void setPlayer(Player player){
        RunesManager.player = player;
    }

    public static void addRunes(int runes){
        player.runes += runes;
    }

    public static void deductRunes(int runes){
        player.runes -= runes;
    }

    public static int getRunes(){
        return player.runes;
    }

}
