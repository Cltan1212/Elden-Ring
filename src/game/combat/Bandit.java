package game.combat;

import game.weapons.GreatKnife;

public class Bandit extends CombatArchetypes {

    // starting weapon is Great Knife
    public Bandit(){
        super(new GreatKnife(), 414);
    }
}
