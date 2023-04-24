package game.combat;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.Club;

public class Wretch extends CombatArchetypes {
    // starting weapon is Club

    public Wretch() {
        super('w', "Wretch", new Club(), 414);
    }
}
