package game.weapons.bossWeapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.traderActions.SellAction;
import game.items.trading.Sellable;
import game.runes.RunesManager;
import game.utils.Status;

/**
 * A weapon item representing a AxeOfGodrick.
 * Implements Sellable interfaces.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see WeaponItem
 * @see Sellable
 */
public class AxeOfGodrick extends WeaponItem implements Sellable {

    /**
     * The price of this weapon
     */
    private final int price = 100;

    /**
     * The sell action of this weapon
     */
    private final SellAction sellAction = new SellAction(this, price);

    /**
     * Constructor.
     */
    public AxeOfGodrick() {
        super("Axe of Godrick", 'T', 142, "hits the surrounding", 84);
    }

    /**
     * Creates a SellAction that allows this Axe of Godrick to be sold to trader for 100 gold.
     *
     * @see SellAction
     */
    @Override
    public void createSellAction(Actor actor, Integer price) {
        RunesManager.getInstance().addRunes(actor, price);
        actor.removeWeaponFromInventory(this);
    }

    /**
     * This weapon does not have special skill.
     */
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
