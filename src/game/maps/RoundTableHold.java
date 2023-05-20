package game.maps;

import java.util.Arrays;

/**
 * RoundTableHold
 * Represent one of the game map
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 * @see MapInitialize
 */
public class RoundTableHold extends MapInitialize{

    /**
     * Constructor
     * for initializing the game map
     */
    public RoundTableHold() {
        super( Arrays.asList(
                "##################",
                "#________________#",
                "#________________#",
                "#________________#",
                "#________________#",
                "#______________=_#",
                "#________________#",
                "#________________#",
                "#________________#",
                "#________________#",
                "########___#######"));
    }
}
