package game.weapons.skeletalDropable;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.AreaAttackAction;
import game.actions.runesActions.PurchaseAction;
import game.actions.runesActions.SellAction;
import game.items.Purchasable;
import game.items.Sellable;
import game.runes.RunesManager;
import game.utils.Status;

/**
 * A weapon item representing a Scimitar.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see WeaponItem
 * @see Purchasable
 * @see Sellable
 */
public class Scimitar extends WeaponItem implements Purchasable, Sellable {

    private final int price = 100;
    private final SellAction sellAction = new SellAction(this, price);

    /**
     * Constructor.
     */
    public Scimitar() {
        super("Scimitar", 's', 118, "perform spinning attack", 88);
    }

    /**
     * The special skill of this weapon.
     *
     * @param holder weapon holder
     * @return an AreaAttackAction for the Scimitar
     * @see AreaAttackAction
     */
    @Override
    public Action getSkill(Actor holder) {
        return new AreaAttackAction(this);
    }

    /**
     * Creates a PurchaseAction that allows this Scimitar to be purchased from a MerchantKale for 600 runes.
     *
     * @return a PurchaseAction for this Scimitar
     * @see PurchaseAction
     */
    @Override
    public PurchaseAction createPurchaseAction() {
        return new PurchaseAction(this, 600);
    }

    /**
     * Creates a SellAction that allows this Scimitar to be sold to a MerchantKale for 100 gold.
     *
     * @return a SellAction for this Scimitar
     * @see SellAction
     */
    @Override
    public void createSellAction(Actor actor, Integer price) {
        RunesManager.getInstance().addRunes(actor, price);
        actor.removeWeaponFromInventory(this);

    }

    @Override
    public void tick(Location currentLocation, Actor actor) {

        if (this.getAllowableActions().contains(sellAction)){
            this.removeAction(sellAction);
            return;
        }
        for (Exit exit: currentLocation.getExits()){
            Location destination = exit.getDestination();

            if (destination.containsAnActor() && destination.getActor().hasCapability(Status.SELL)){
                this.addAction(sellAction);
            }
        }

    }
}