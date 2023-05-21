package game.combat;

import game.weapons.combat.Club;

/**
 * Wretch
 * One of the starting game mode
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 * @see CombatArchetypes
 */
public class Wretch extends CombatArchetypes {

    /**
     * Constructor
     *
     * Set the display character, the starting weapon and starting hit point for this game mode
     */
    public Wretch(){
        // starting weapon is Club
        super('w', "Wretch", new Club(), 414);
    }
}
