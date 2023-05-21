package game.weapons.combat;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.traderActions.PurchaseAction;
import game.actions.traderActions.SellAction;
import game.items.trading.Purchasable;
import game.items.trading.Sellable;
import game.runes.RunesManager;
import game.utils.Status;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see WeaponItem
 * @see Sellable
 * @see Purchasable
 */
public class Club extends WeaponItem implements Sellable, Purchasable {

    /**
     * The price of this weapon.
     */
    private final int price = 100;

    /**
     * The sell action with this weapon.
     */
    private final SellAction sellAction = new SellAction(this, price);

    /**
     * Constructor
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
    }

    /**
     * This weapon does not have special skill.
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return null;
    }

    /**
     * Creates a PurchaseAction that allows this Club to be purchased from a MerchantKale for 600 runes.
     *
     * @return a PurchaseAction for this Club
     * @see PurchaseAction
     */
    @Override
    public PurchaseAction createPurchaseAction() {
        return new PurchaseAction(this, 600);
    }

    /**
     * Creates a SellAction that allows this Club to be sold to trader for 100 gold.
     *
     */
    @Override
    public void createSellAction(Actor actor, Integer price) {
        RunesManager.getInstance().addRunes(actor, price);
        actor.removeWeaponFromInventory(this);

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
