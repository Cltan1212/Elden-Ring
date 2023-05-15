package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.AreaAttackAction;
import game.actions.runesActions.SellAction;
import game.items.Sellable;

public class GiantDragonFlyHead extends WeaponItem implements Sellable {
    /**
     * Constructor.
     *
     */
    public GiantDragonFlyHead() {
        super("Giant Dragon Fly Head",'¶',131,"slams",98);
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

    @Override
    public SellAction createSellAction() {
        return new SellAction(this, 10);
    }
}
