package game.weapons.skeletalDropable;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.attackActions.AreaAttackAction;
import game.actions.traderActions.SellAction;
import game.items.trading.Purchasable;
import game.items.trading.Sellable;
import game.runes.RunesManager;
import game.utils.Status;

/**
 * A heavy sword that deals high damage and can perform an area attack.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see WeaponItem
 * @see Purchasable
 */
public class Grossmesser extends WeaponItem implements Sellable {

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
    public Grossmesser() {
        super("Grossmesser", '?',115, "perform spinning attack", 85);
    }

    /**
     * Returns the area attack action for the grossmesser.
     *
     * @param holder the actor holding the grossmesser
     * @return an AreaAttackAction object
     * @see AreaAttackAction
     */
    @Override
    public Action getSkill(Actor holder) {
        return new AreaAttackAction(this);
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return null;
    }

    /**
     * Creates a SellAction that allows this Grossmesser to be sold to a MerchantKale for 100 gold.
     *
     * @return a SellAction for this Grossmesser
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
