package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class Eraser extends WeaponItem {
    /**
     * Constructor.
     *
     */
    public Eraser() {
        super("Eraser", '`',2147483647,"attacks",100);
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return null;
    }
}
