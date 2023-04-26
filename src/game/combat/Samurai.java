package game.combat;

import game.weapons.Uchigatana;

public class Samurai extends CombatArchetypes {
    // starting weapon is Uchigatana
    public Samurai() {
        super('s',"Sarumai", new Uchigatana(), 455);
    }
}
