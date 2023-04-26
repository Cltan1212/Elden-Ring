package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.runesActions.PurchaseAction;
import game.actions.runesActions.SellAction;
import game.items.Purchasable;
import game.items.Sellable;

public class Scimitar extends WeaponItem implements Purchasable, Sellable {

    public Scimitar() {
        super("Scimitar", 's', 118, " ", 88);
    }

    @Override
    public PurchaseAction createPurchaseAction() {
        return new PurchaseAction(this, 600);
    }

    @Override
    public SellAction createSellAction() {
        return new SellAction(this, 100);
    }
}
