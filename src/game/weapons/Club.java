package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.runesActions.PurchaseAction;
import game.actions.runesActions.SellAction;
import game.actors.MerchantKale;
import game.items.Purchasable;
import game.items.Sellable;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Club extends WeaponItem implements Sellable, Purchasable {

    /**
     * Constructor
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
        MerchantKale.getInstance().registerPurchasableItem(this);
        MerchantKale.getInstance().registerSellableItem(this);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}

    @Override
    public PurchaseAction createPurchaseAction() {
        return new PurchaseAction(this, 5000);
    }

    @Override
    public SellAction createSellAction() {
        return new SellAction(this,100);

    }
}
