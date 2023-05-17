package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.ExchangeAction;
import game.actions.runesActions.SellAction;
import game.runes.Runes;
import game.runes.RunesManager;
import game.utils.Status;
import game.weapons.AxeOfGodrick;
import game.weapons.GraftedDragon;

public class RemembranceOfTheGrafted extends Item implements Exchangeable, Sellable {
    private final int price = 20000;
    private AxeOfGodrick axeOfGodrick = new AxeOfGodrick();
    private GraftedDragon graftedDragon = new GraftedDragon();
    private final SellAction sellAction = new SellAction(this, price);
    private final ExchangeAction exchangeAxeOfGodrickAction = new ExchangeAction(this, axeOfGodrick);
    private final ExchangeAction exchangeGraftedDragonAction = new ExchangeAction(this, graftedDragon);
    /***
     * Constructor.
     */
    public RemembranceOfTheGrafted() {
        super("Remembrance Of The Grafted", 'O', true);
    }

    @Override
    public void createExchangeAction(Actor actor, WeaponItem receiveItem) {
        actor.removeItemFromInventory(this);
        actor.addWeaponToInventory(receiveItem);
    }

    @Override
    public void createSellAction(Actor actor, Integer price) {
        RunesManager.getInstance().addRunes(actor, price);
        actor.removeItemFromInventory(this);
    }
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
