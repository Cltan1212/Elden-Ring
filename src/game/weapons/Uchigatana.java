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

public class Uchigatana extends WeaponItem implements Purchasable, Sellable {
    /**
     * Constructor.
     */
    public Uchigatana (){
        super("Uchigatana", ')', 115,"unsheathe", 80);
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return new UnsheatheAction(this, target);
    }

    @Override
    public PurchaseAction createPurchaseAction() {
        return new PurchaseAction(this, 5000);
    }

    @Override
    public SellAction createSellAction() {
        return new SellAction(this, 500);
    }
}
