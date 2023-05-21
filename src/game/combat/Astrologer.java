package game.combat;

import game.weapons.combat.GreatKnife;

/**
 * Astrologer
 * One of the starting game mode
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 * @see CombatArchetypes
 */

public class Astrologer extends CombatArchetypes {

    /**
     * Constructor
     *
     * Set the display character, the starting weapon and starting hit point for this game mode
     */
    public Astrologer(){
        // starting weapon is Great Knife
        // since we didn't implement New Weapon (optional) we choose GreatKnife as the starting weapon of Astrologer
        super('a', "Astrologer", new GreatKnife(), 396);
    }
}