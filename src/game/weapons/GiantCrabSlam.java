package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.AreaAttackAction;
import game.actions.actorActions.AttackAction;

/**
 * A weapon item representing the skill "Giant Crab Slam".
 * It deals 208 damage with 90% hit rate when attacking a single target,
 * or performs an area attack when attacking with no target.
 * @see WeaponItem
 */
public class GiantCrabSlam extends WeaponItem {
    public GiantCrabSlam() {
        super("Giant Crab Slam", ' ', 208 , "slams", 90);
        portable = false;
    }

    /**
     * Returns an AttackAction with the target and direction for this weapon.
     *
     * @param target target actor
     * @param direction the direction of the attack
     * @return an AttackAction with the target and direction for this weapon
     * @see AttackAction
     */
    @Override
    public Action getSkill(Actor target, String direction){
        return new AttackAction(target, direction,this);
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
