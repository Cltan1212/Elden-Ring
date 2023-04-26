package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.UnsheatheAction;
import game.actions.runesActions.PurchaseAction;
import game.actions.runesActions.SellAction;
import game.actors.MerchantKale;
import game.items.Purchasable;
import game.items.Sellable;
import game.utils.Status;

public class Uchigatana extends WeaponItem implements Purchasable, Sellable {
    private boolean unsheatheale;

    /**
     * Constructor.
     */
    public Uchigatana() {
        super("Uchigatana", ')', 115, "slashes", 80);

        // perform "Unsheathe"
        this.addCapability(Status.UNSHEATHE);
        this.unsheatheale = true;
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation, actor);
    }

    @Override
    public PurchaseAction createPurchaseAction() {
        return new PurchaseAction(this, 5000);
    }

    @Override
    public SellAction createSellAction() {
        return new SellAction(this, 500);
    }

    public boolean isUnsheatheable(){
        return this.unsheatheale;
    }

    /**
     * Get an active skill action from the weapon. This should be used for weapon skills that do not involve a target actor
     * For instance, healing the holder of the weapon, switching current weapon's attack, e.g. from normal attack to fire attack
     * @param holder weapon holder
     * @return a special Action that can be performed by this weapon (heal the player, etc.)
     */
    @Override
    public Action getSkill(Actor holder){
        if (this.hasCapability(Status.UNSHEATHE)){
            return new UnsheatheAction(this, holder);
        }else{
            return null;
        }

    }

}
