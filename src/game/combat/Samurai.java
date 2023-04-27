package game.combat;

import game.weapons.Uchigatana;

public class Samurai extends CombatArchetypes {

    // starting weapon is Uchigatana
    public Samurai() {
        super('s',"Samurai", new Uchigatana(), 455);
    }
}



