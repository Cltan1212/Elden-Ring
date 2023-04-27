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

public class GreatKnife extends WeaponItem implements Purchasable, Sellable {

    public GreatKnife(){
        super("Great Knife", '/', 75,"quick step", 70);

        // allow the user to perform quickstep
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return new QuickStepAction(target, direction, this);
    }

    @Override
    public PurchaseAction createPurchaseAction() {
        return new PurchaseAction(this,3500);
    }

    @Override
    public SellAction createSellAction() {
        return new SellAction(this,350);
    }

}
