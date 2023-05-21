package game.weapons.skeletalDropable;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.attackActions.AreaAttackAction;
import game.actions.traderActions.SellAction;
import game.items.trading.Sellable;
import game.runes.RunesManager;
import game.utils.Status;

/**
 * A weapon item representing a GraveScythe.
 * Implements Sellable interfaces.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see WeaponItem
 * @see Sellable
 */

public class GraveScythe extends WeaponItem implements Sellable {

    /**
     * The price of this weapon.
     */
    private final int price = 150;

    /**
     * The sell action with this weapon.
     */
    private final SellAction sellAction = new SellAction(this, price);

    /**
     * Constructor.
     */
    public GraveScythe() {
        super("GraveScythe",'/',144,"perform spinning attack",90);
    }

    /**
     * Returns the area attack action for the Grave Scythe.
     *
     * @param holder the actor holding the Grave Scythe.
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
     * Creates a SellAction that allows this GraveScythe to be sold to trader for 150 gold.
     *
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
        for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();

            if (destination.containsAnActor() && destination.getActor().hasCapability(Status.SELL)) {
                this.addAction(sellAction);
            }
        }
    }
}
