package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.RangeAttackAction;
import game.actions.runesActions.PurchaseAction;
import game.actions.runesActions.SellAction;
import game.items.Purchasable;
import game.items.Sellable;
import game.runes.RunesManager;
import game.utils.Status;

public class AstrologerStaff extends WeaponItem implements Sellable, Purchasable {

    private final int price = 100;
    private final SellAction sellAction = new SellAction(this, price);

    /**
     * Constructor.
     */
    public AstrologerStaff() {
        super("Astrologer's Staff",'f',274,"shoot",50);
    }
    @Override
    public Action getSkill(Actor target, String direction){
        return new RangeAttackAction(3,this, target);
    }

    @Override
    public PurchaseAction createPurchaseAction() {
        return new PurchaseAction(this, 800);
    }

    /**
     * Creates a SellAction that allows this Astrologer's Staff to be sold to a MerchantKale for 500 gold.
     *
     * @return a SellAction for this Staff
     * @see SellAction
     */
    @Override
    public void createSellAction(Actor actor, Integer price) {
        RunesManager.getInstance().addRunes(actor, price);
        actor.removeWeaponFromInventory(this);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {

        if (this.getAllowableActions().contains(sellAction)){
            this.removeAction(sellAction);
            return;
        }
        for (Exit exit: currentLocation.getExits()){
            Location destination = exit.getDestination();

            if (destination.containsAnActor() && destination.getActor().hasCapability(Status.SELL)){
                this.addAction(sellAction);
            }
        }
    }
}
