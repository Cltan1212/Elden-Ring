package game.weapons.skeletalDropable;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.AreaAttackAction;
import game.actions.runesActions.SellAction;
import game.items.Sellable;

public class GraveScythe extends WeaponItem implements Sellable {
    /**
     * Constructor.
     */
    public GraveScythe() {
        super("GraveScythe",'/',144,"perform spinning attack",90);
    }

    /**
     * Returns the area attack action for the Grave Scythe.
     *
     * @param holder the actor holding the Grave Scythe.
     * @return an AreaAttackAction object
     * @see AreaAttackAction
     */
    @Override
    public Action getSkill(Actor holder) {
        return new AreaAttackAction(this);
    }

    @Override
    public SellAction createSellAction() {
        return new SellAction(this, 100);
    }
}
