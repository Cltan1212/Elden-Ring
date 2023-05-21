package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.traderActions.ExchangeAction;
import game.actions.traderActions.SellAction;
import game.items.trading.Exchangeable;
import game.items.trading.Sellable;
import game.runes.RunesManager;
import game.utils.Status;
import game.weapons.bossWeapons.AxeOfGodrick;
import game.weapons.bossWeapons.GraftedDragon;

/**
 * Remembrance of the Grafted
 * This class represents an item in the game
 *
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see Item
 * @see Exchangeable
 * @see Sellable
 */

public class RemembranceOfTheGrafted extends Item implements Exchangeable, Sellable {
    /**
     * The selling price of this item.
     */
    private final int price = 20000;

    /**
     * The sell action of this item.
     */
    private final SellAction sellAction = new SellAction(this, price);

    /**
     * The exchange action for this item.
     */
    private final ExchangeAction exchangeAxeOfGodrickAction = new ExchangeAction(this, new AxeOfGodrick());

    /**
     * The exchange action for this item.
     */
    private final ExchangeAction exchangeGraftedDragonAction = new ExchangeAction(this, new GraftedDragon());

    /***
     * Constructor.
     */
    public RemembranceOfTheGrafted() {
        super("Remembrance Of The Grafted", 'O', true);
    }

    /**
     * Creates a SellAction that allows this RemembranceOfTheGrafted to be exchanged to trader.
     *
     * @param actor The actor perform the exchange action
     * @param receiveItem The item that received by the actor
     */
    @Override
    public void createExchangeAction(Actor actor, WeaponItem receiveItem) {
        actor.removeItemFromInventory(this);
        actor.addWeaponToInventory(receiveItem);
    }

    /**
     * Creates a SellAction that allows this RemembranceOfTheGrafted to be sold to a trader for 20000 gold.
     *
     * @param actor The actor perform sell action
     * @param price The price of the item
     */
    @Override
    public void createSellAction(Actor actor, Integer price) {
        RunesManager.getInstance().addRunes(actor, price);
        actor.removeItemFromInventory(this);
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
        if (this.getAllowableActions().contains(exchangeAxeOfGodrickAction)){
            this.removeAction(exchangeAxeOfGodrickAction);
        }
        if (this.getAllowableActions().contains(exchangeGraftedDragonAction)){
            this.removeAction(exchangeGraftedDragonAction);
        }
        if (this.getAllowableActions().contains(sellAction)){
            this.removeAction(sellAction);
        }
        for (Exit exit: currentLocation.getExits()){
            Location destination = exit.getDestination();

            if (destination.containsAnActor() && destination.getActor().hasCapability(Status.SELL)){
                this.addAction(sellAction);
            }
            if (destination.containsAnActor() && destination.getActor().hasCapability(Status.EXCHANGE)){
                this.addAction(exchangeGraftedDragonAction);
                this.addAction(exchangeAxeOfGodrickAction);
            }
        }

    }
}
