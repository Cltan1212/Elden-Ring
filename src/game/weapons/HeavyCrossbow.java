package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.RangeAttackAction;
import game.actions.runesActions.PurchaseAction;
import game.actions.runesActions.SellAction;
import game.items.Purchasable;
import game.items.Sellable;

public class HeavyCrossbow extends WeaponItem implements Sellable, Purchasable {
    /**
     * Constructor.
     */
    public HeavyCrossbow() {
        super("Heavy Cross Bow",'}',64,"shoot",57);
    }

    @Override
    public Action getSkill(Actor target, String direction){
        return new RangeAttackAction(2,this, target);
    }

    @Override
    public PurchaseAction createPurchaseAction() {
        return new PurchaseAction(this,1500);
    }

    @Override
    public SellAction createSellAction() {
        return new SellAction(this, 100);
    }
}
