package game.maps;


import java.util.Arrays;

/**
 * BossRoom
 * Represent one of the game map
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 * @see MapInitialize
 */

public class BossRoom extends MapInitialize{

    /**
     * Constructor
     * for initializing the game map
     */
    public BossRoom() {
        super( Arrays.asList(
                "+++++++++++++++++++++++++",
                ".........................",
                "..=......................",
                ".........................",
                ".........................",
                ".........................",
                ".........................",
                ".........................",
                "+++++++++++++++++++++++++"));
    }
}
