package game.weapons.combat;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.attackActions.UnsheatheAction;
import game.actions.traderActions.PurchaseAction;
import game.actions.traderActions.SellAction;
import game.items.trading.Purchasable;
import game.items.trading.Sellable;
import game.runes.RunesManager;
import game.utils.Status;

/**
 * A weapon item representing a Uchigatana.
 * A Uchigatana can be unsheathed by an actor, allowing them to perform a powerful attack on their target.
 * It can also be purchased from a merchant, or sold by the player.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see WeaponItem
 * @see Purchasable
 * @see Sellable
 */
public class Uchigatana extends WeaponItem implements Purchasable, Sellable {

    /**
     * The price of this weapon.
     */
    private final int price = 350;

    /**
     * The sell action with this weapon.
     */
    private final SellAction sellAction = new SellAction(this, price);
    /**
     * Constructor.
     */
    public Uchigatana (){
        super("Uchigatana", ')', 115,"unsheathe", 80);
    }

    /**
     * The special skill of Uchigatana.
     *
     * @param target target actor
     * @param direction the direction in which the Actor is being attacked
     * @return a UnsheatheAction
     * @see UnsheatheAction
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new UnsheatheAction(this, target);
    }

    /**
     * Creates a PurchaseAction that allows this Uchigatana to be purchased from a MerchantKale for 5000 runes.
     *
     * @return a PurchaseAction for this Uchigatana
     * @see PurchaseAction
     */
    @Override
    public PurchaseAction createPurchaseAction() {
        return new PurchaseAction(this, 5000);
    }

    /**
     * Creates a SellAction that allows this Uchigatana to be sold to a MerchantKale for 500 gold.
     *
     * @return a SellAction for this Uchigatana
     * @see SellAction
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
