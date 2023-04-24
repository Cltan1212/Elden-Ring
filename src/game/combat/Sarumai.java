package game.combat;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.Uchigatana;

public class Sarumai extends CombatArchetypes {
    // starting weapon is Uchigatana
    public Sarumai() {
        super('s',"Sarumai", new Uchigatana(), 455);
    }
}
