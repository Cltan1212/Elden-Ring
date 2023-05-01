package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.AttackAction;
import game.actions.actorActions.QuickStepAction;
import game.actions.runesActions.PurchaseAction;
import game.actions.runesActions.SellAction;
import game.actors.MerchantKale;
import game.items.Purchasable;
import game.items.Sellable;
import game.utils.Status;

/**
 * A weapon item representing a great knife.
 * Implements Purchasable and Sellable interfaces.
 * @see WeaponItem
 * @see Purchasable
 * @see Sellable
 */
public class GreatKnife extends WeaponItem implements Purchasable, Sellable {

    /**
     * Constructor.
     */
    public GreatKnife(){
        super("Great Knife", '/', 75,"quick step", 70);
    }

    /**
     * Returns a QuickStepAction with target and direction.
     *
     * @param target target actor
     * @param direction the direction in which the Actor is being attacked
     * @return a QuickStepAction with target and direction
     * @see QuickStepAction
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new QuickStepAction(target, direction, this);
    }

    /**
     * Creates a PurchaseAction that allows this GreatKnife to be purchased from a MerchantKale for 3500 runes.
     *
     * @return a PurchaseAction for this GreatKnife
     */
    @Override
    public PurchaseAction createPurchaseAction() {
        return new PurchaseAction(this,3500);
    }

    /**
     * Creates a SellAction that allows this GreatKnife to be sold to a MerchantKale for 350 gold.
     *
     * @return a SellAction for this GreatKnife
     */
    @Override
    public SellAction createSellAction() {
        return new SellAction(this,350);
    }

}
