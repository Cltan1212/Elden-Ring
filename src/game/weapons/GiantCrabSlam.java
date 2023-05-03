package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.AreaAttackAction;

/**
 * A weapon item representing the skill "Giant Crab Slam".
 * It deals 208 damage with 90% hit rate when attacking a single target,
 * or performs an area attack when attacking with no target.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see WeaponItem
 */
public class GiantCrabSlam extends WeaponItem {
    /**
     * Constructor.
     */
    public GiantCrabSlam() {
        super("Giant Crab Slam", ' ', 208 , "slams", 90);
        portable = false;
    }

    /**
     * Returns an AreaAttackAction for this weapon.
     *
     * @param holder weapon holder
     * @return an AreaAttackAction for this weapon
     * @see AreaAttackAction
     */
    @Override
    public Action getSkill(Actor holder) {
        return new AreaAttackAction(this);
    }
}
