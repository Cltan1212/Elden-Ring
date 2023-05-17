package game.combat;

import game.weapons.combat.Uchigatana;

/**
 * Samurai
 * One of the starting game mode
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 * @see CombatArchetypes
 */
public class Samurai extends CombatArchetypes {

    /**
     * Constructor
     *
     * Set the display character, the starting weapon and starting hit point for this game mode
     */
    public Samurai() {
        // starting weapon is Uchigatana
        super('s',"Samurai", new Uchigatana(), 455);
    }
}



