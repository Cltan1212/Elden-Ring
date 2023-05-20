package game.weapons.skeletalDropable;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.attackActions.AreaAttackAction;
import game.actions.traderActions.PurchaseAction;
import game.actions.traderActions.SellAction;
import game.items.trading.Purchasable;
import game.items.trading.Sellable;
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

    /**
     * The price of this weapon.
     */
    private final int price = 100;

    /**
     * The sell action with this weapon.
     */
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
    public Action getSkill(Actor target, String direction) {
        return null;
    }

    /**
     * Inform a carried Item of the passage of time.
     *
     * This method is called once per turn, if the Item is being carried.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (this.getAllowableActions().contains(sellAction)){
            this.removeAction(sellAction);
        }
        for (Exit exit: currentLocation.getExits()){
            Location destination = exit.getDestination();

            if (destination.containsAnActor() && destination.getActor().hasCapability(Status.SELL)){
                this.addAction(sellAction);
            }
        }

    }
}
