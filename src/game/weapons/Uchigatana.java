package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.UnsheatheAction;
import game.actions.runesActions.PurchaseAction;
import game.actions.runesActions.SellAction;
import game.actors.MerchantKale;
import game.items.Purchasable;
import game.items.Sellable;

/**
 * A weapon item representing a Uchigatana.
 * A Uchigatana can be unsheathed by an actor, allowing them to perform a powerful attack on their target.
 * It can also be purchased from a merchant, or sold by the player.
 * @see WeaponItem
 * @see Purchasable
 * @see Sellable
 */
public class Uchigatana extends WeaponItem implements Purchasable, Sellable {
    /**
     * Constructor.
     */
    public Uchigatana (){
        super("Uchigatana", ')', 115,"unsheathe", 80);
    }

    /**
     * The special skill of Uchigatana.
     *
     * @param target target actor
     * @param direction the direction in which the Actor is being attacked
     * @return a UnsheatheAction
     * @see UnsheatheAction
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new UnsheatheAction(this, target);
    }

    /**
     * Creates a PurchaseAction that allows this Uchigatana to be purchased from a MerchantKale for 5000 runes.
     *
     * @return a PurchaseAction for this Uchigatana
     * @see PurchaseAction
     */
    @Override
    public PurchaseAction createPurchaseAction() {
        return new PurchaseAction(this, 5000);
    }

    /**
     * Creates a SellAction that allows this Uchigatana to be sold to a MerchantKale for 500 gold.
     *
     * @return a SellAction for this Uchigatana
     * @see SellAction
     */
    @Override
    public SellAction createSellAction() {
        return new SellAction(this, 500);
    }
}
