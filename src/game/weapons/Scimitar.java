package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.AreaAttackAction;
import game.actions.runesActions.PurchaseAction;
import game.actions.runesActions.SellAction;
import game.items.Purchasable;
import game.items.Sellable;

public class Scimitar extends WeaponItem implements Purchasable, Sellable {

    public Scimitar() {
        super("Scimitar", 's', 118, "perform spinning attack", 88);
    }

    @Override
    public Action getSkill(Actor holder) {
        return new AreaAttackAction(this);
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
