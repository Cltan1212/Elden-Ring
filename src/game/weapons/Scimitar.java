package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.AreaAttackAction;
import game.actions.runesActions.PurchaseAction;
import game.actions.runesActions.SellAction;
import game.items.Purchasable;
import game.items.Sellable;

/**
 * A weapon item representing a Scimitar.
 * @see WeaponItem
 * @see Purchasable
 * @see Sellable
 */
public class Scimitar extends WeaponItem implements Purchasable, Sellable {

    /**
     * Constructor.
     */
    public Scimitar() {
        super("Scimitar", 's', 118, "perform spinning attack", 88);
    }

    /**
     * The special skill of this weapon.
     *
     * @param holder weapon holder
     * @return an AreaAttackAction for the Scimitar
     * @see AreaAttackAction
     */
    @Override
    public Action getSkill(Actor holder) {
        return new AreaAttackAction(this);
    }

    /**
     * Creates a PurchaseAction that allows this Scimitar to be purchased from a MerchantKale for 600 runes.
     *
     * @return a PurchaseAction for this Scimitar
     * @see PurchaseAction
     */
    @Override
    public PurchaseAction createPurchaseAction() {
        return new PurchaseAction(this, 600);
    }

    /**
     * Creates a SellAction that allows this Scimitar to be sold to a MerchantKale for 100 gold.
     *
     * @return a SellAction for this Scimitar
     * @see SellAction
     */
    @Override
    public SellAction createSellAction() {
        return new SellAction(this, 100);
    }
}
