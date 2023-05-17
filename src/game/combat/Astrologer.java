package game.combat;

import game.weapons.AstrologerStaff;
import game.weapons.GreatKnife;

public class Astrologer extends CombatArchetypes {

    /**
     * Constructor
     *
     * Set the display character, the starting weapon and starting hit point for this game mode
     */
    public Astrologer(){
        // starting weapon is Staff
        super('a', "Astrologer", new AstrologerStaff(), 396);
    }
}