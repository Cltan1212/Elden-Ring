package game.weapons.enemySpecial;

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

public class GiantDragonFlyHead extends WeaponItem implements Sellable {
    private final int price = 100;
    private final SellAction sellAction = new SellAction(this, price);
    /**
     * Constructor.
     *
     */
    public GiantDragonFlyHead() {
        super("Giant Dragon Fly Head",'>',131,"slams",98);
    }

    /**
     * Returns a new AreaAttackAction.
     *
     * @param holder weapon holder
     * @return a new AreaAttackAction
     * @see AreaAttackAction
     */
    @Override
    public Action getSkill(Actor holder) {
        return new AreaAttackAction(this);
    }

    @Override
    public void createSellAction(Actor actor, Integer price) {
        RunesManager.getInstance().addRunes(actor, price);
        actor.removeWeaponFromInventory(this);

    }

    @Override
    public void tick(Location currentLocation, Actor actor) {

        if (this.getAllowableActions().contains(sellAction)) {
            this.removeAction(sellAction);
            return;
        }
        for (Exit exit : currentLocation.getExits()) {
            Location destination = exit.getDestination();

            if (destination.containsAnActor() && destination.getActor().hasCapability(Status.SELL)) {
                this.addAction(sellAction);
            }
        }
    }
}
