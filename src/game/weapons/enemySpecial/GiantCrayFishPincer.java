package game.weapons.enemySpecial;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.attackActions.AreaAttackAction;

/**
 * A type of WeaponItem that represents the Giant CrayFish Pincer, a powerful weapon used by the Giant CrayFish.
 * It deals 527 damage with a hit rate of 100% and has a special skill that can be used for area attacks.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see WeaponItem
 */
public class GiantCrayFishPincer extends WeaponItem {

    /**
     * Constructor.
     */
    public GiantCrayFishPincer() {
        super("Giant CrayFish Pincer", ' ', 527, "slams", 100);
        portable = false;
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return null;
    }

    /**
     * Returns an AreaAttackAction using this GiantCrayFishPincer.
     *
     * @param holder weapon holder
     * @return  an AreaAttackAction with this GiantCrayFishPincer
     * @see AreaAttackAction
     */
    @Override
    public Action getSkill(Actor holder) {
        return new AreaAttackAction(this);
    }


}
