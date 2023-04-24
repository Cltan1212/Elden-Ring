package game.items;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.runesActions.PurchaseAction;

public interface Purchasable {

    public PurchaseAction createPurchaseAction();
}
