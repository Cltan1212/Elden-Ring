package game.actions.tradingActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.runes.RunesManager;
import game.utils.Status;

public class purchaseAction extends Action {

    private WeaponItem weaponItem;
    private int price;

    public purchaseAction(WeaponItem weaponItem, int price){
        setWeaponItem(weaponItem);
        setPrice(price);
    }

    public WeaponItem getWeaponItem() {
        return weaponItem;
    }

    public void setWeaponItem(WeaponItem weaponItem) {
        this.weaponItem = weaponItem;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        String message = "";
        if (actor.hasCapability(Status.BUYING) && RunesManager.getRunesValue() >= getPrice()){
            RunesManager.subtractRunesValue(price);
            actor.addWeaponToInventory(weaponItem);
            message = actor + " successfully purchase " + weaponItem.toString();
        }
        else{
            message += actor + " do not have enough coins to buy " + weaponItem.toString() + "!";
        }
        return  message;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
