package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.runesActions.SellAction;
import game.items.Exchangeable;
import game.items.Sellable;
import game.runes.RunesManager;
import game.utils.Status;

public class AxeOfGodrick extends WeaponItem implements Sellable {
    private final int price = 100;
    private final SellAction sellAction = new SellAction(this, price);

    /**
     * Constructor.
     */
    public AxeOfGodrick() {
        super("Axe of Godrick", 'T', 142, "hits the surrounding", 84);
    }


    @Override
    public void createSellAction(Actor actor, Integer price) {
        RunesManager.getInstance().addRunes(actor, price);
        actor.removeWeaponFromInventory(this);
    }
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
