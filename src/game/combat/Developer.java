package game.combat;

import game.weapons.Eraser;

/**
 * Developer
 * One of the starting game mode
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 * @see CombatArchetypes
 */

public class Developer extends CombatArchetypes{
    /**
     * Constructor
     *
     * For testing purpose.
     * @see Eraser
     */
    public Developer() {
        super('D',"Developer",new Eraser(),2147483547);
    }
}
