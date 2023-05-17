package game.combat;

import game.weapons.combat.GreatKnife;

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