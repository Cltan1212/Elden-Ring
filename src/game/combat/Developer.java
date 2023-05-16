package game.combat;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.Uchigatana;

public class Developer extends CombatArchetypes{
    /**
     * Constructor
     *
     * For testing purpose
     */
    public Developer() {
        super('D',"Developer",new Uchigatana(),1000000000);
    }
}
