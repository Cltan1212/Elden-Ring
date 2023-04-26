package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.AreaAttackAction;
import game.actions.actorActions.AttackAction;
import game.actions.runesActions.SellAction;
import game.actors.MerchantKale;
import game.items.Purchasable;
import game.items.Sellable;
import game.utils.Status;

public class Grossmesser extends WeaponItem implements Sellable {
    public Grossmesser() {
        super("Grossmesser", '?',115, "", 85);
//        MerchantKale.getInstance().registerSellableItem(this);
//        this.addCapability(Status.SPINNING_ATTACK);
    }

    @Override
    public SellAction createSellAction() {
        return new SellAction(this,100);
    }

    @Override
    public Action getSkill(Actor holder) {
        if (this.hasCapability(Status.SPINNING_ATTACK)) {
            // holder -> attacker? (enemy)
            return new AreaAttackAction(holder, this);
        } else {
            return new AttackAction(holder, " ",this);
        }
    }
}
