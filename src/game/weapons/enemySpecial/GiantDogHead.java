package game.weapons.enemySpecial;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.attackActions.AreaAttackAction;

/**
 * A weapon that represents a giant dog head, which can be used to attack enemies.
 * It has an attack damage of 208 with a hit rate of 90%.
 * It also has the ability to perform an area attack.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see WeaponItem
 */
public class GiantDogHead extends WeaponItem {

    /**
     * Constructor.
     */
    public GiantDogHead() {
        super("Giant Dog Slam", ' ', 208, "slams", 90);
        portable = false;
    }

    /**
     * Returns a new AreaAttackAction.
     *
     * @param holder weapon holder
     * @return a new AreaAttackAction
     * @see AreaAttackAction
     */
    @Override
    public Action getSkill(Actor holder) {
        return new AreaAttackAction(this);
    }
}
