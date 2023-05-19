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

public class GraveScythe extends WeaponItem implements Sellable {
    private final int price = 150;
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

    @Override
    public void createSellAction(Actor actor, Integer price) {
        RunesManager.getInstance().addRunes(actor, price);
        actor.removeWeaponFromInventory(this);

    }

    @Override
    public void tick(Location currentLocation) {
        this.removeAction(sellAction);
    }

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
