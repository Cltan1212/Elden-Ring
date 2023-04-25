package game.actions.runesActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.Purchasable;
import game.runes.RunesManager;
import game.utils.Status;

public class PurchaseAction extends Action {

    private WeaponItem purchasableItem;
    private int price;

    public PurchaseAction(WeaponItem purchasableItem, int price){
        this.purchasableItem = purchasableItem;
        this.price = price;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String message = "";

        if (RunesManager.getInstance().getRunes(actor) >= price){
            RunesManager.getInstance().deductRunes(actor,price);
            actor.addWeaponToInventory(purchasableItem);
            message = actor + " successfully purchase " + purchasableItem.toString();
        }
        else{
            message += actor + " do not have enough coins to buy " + purchasableItem.toString() + "!";
        }
        return  message;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " purchase " + purchasableItem.toString() + " with $" + price;
    }
}
