package game.combat;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.GreatKnife;

public class Bandit extends CombatArchetypes {
    // starting weapon is Great Knife
    public Bandit() {
        super('b', "Bandit", new GreatKnife(), 414);
    }




}
