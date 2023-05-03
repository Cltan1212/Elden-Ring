package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.runesActions.PurchaseAction;
import game.actions.runesActions.SellAction;
import game.items.Purchasable;
import game.items.Sellable;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see WeaponItem
 * @see Sellable
 * @see Purchasable
 */
public class Club extends WeaponItem implements Sellable, Purchasable {

    /**
     * Constructor
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
    }

    /**
     * Creates a PurchaseAction that allows this Club to be purchased from a MerchantKale for 600 runes.
     *
     * @return a PurchaseAction for this Club
     * @see PurchaseAction
     */
    @Override
    public PurchaseAction createPurchaseAction() {
        return new PurchaseAction(this, 600);
    }

    /**
     * Creates a SellAction that allows this Club to be sold to a MerchantKale for 100 gold.
     *
     * @return a SellAction for this Club
     * @see SellAction
     */
    @Override
    public SellAction createSellAction() {
        return new SellAction(this,100);

    }
}
