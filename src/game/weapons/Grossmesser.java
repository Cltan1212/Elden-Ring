package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.AreaAttackAction;
import game.actions.runesActions.SellAction;
import game.actors.MerchantKale;
import game.items.Purchasable;
import game.items.Sellable;
import game.utils.Status;

/**
 * A heavy sword that deals high damage and can perform an area attack.
 * @see WeaponItem
 * @see Purchasable
 */
public class Grossmesser extends WeaponItem implements Sellable {

    /**
     * Constructor.
     */
    public Grossmesser() {
        super("Grossmesser", '?',115, "perform spinning attack", 85);
    }

    /**
     * Returns the area attack action for the grossmesser.
     *
     * @param holder the actor holding the grossmesser
     * @return an AreaAttackAction object
     * @see AreaAttackAction
     */
    @Override
    public Action getSkill(Actor holder) {
        return new AreaAttackAction(this);
    }

    /**
     * Creates a SellAction that allows this Grossmesser to be sold to a MerchantKale for 100 gold.
     *
     * @return a SellAction for this Grossmesser
     */
    @Override
    public SellAction createSellAction() {
        return new SellAction(this,100);
    }
}
