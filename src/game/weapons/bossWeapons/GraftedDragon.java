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

public class GraftedDragon extends WeaponItem implements Sellable {
    private final int price = 200;
    private final SellAction sellAction = new SellAction(this, price);
    /**
     * Constructor.
     */
    public GraftedDragon() {
        super("Grafted Dragon", 'N', 89, "hits the surrounding", 90);
    }


    @Override
    public void createSellAction(Actor actor, Integer price) {
        RunesManager.getInstance().addRunes(actor, price);
        actor.removeWeaponFromInventory(this);
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return null;
    }

    @Override
    public void tick(Location currentLocation) {
        this.removeAction(sellAction);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        for (Exit exit: currentLocation.getExits()){
            Location destination = exit.getDestination();

            if (destination.containsAnActor() && destination.getActor().hasCapability(Status.SELL)){
                this.addAction(sellAction);
            }
        }

    }
}
