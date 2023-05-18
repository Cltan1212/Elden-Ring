package game.combat;

import game.weapons.Eraser;

public class Developer extends CombatArchetypes{
    /**
     * Constructor
     *
     * For testing purpose
     */
    public Developer() {
        super('D',"Developer",new Eraser(),2147483647);
    }
}
