package game.actions.tradingActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.runes.RunesManager;
import game.utils.Status;

public class SellAction extends Action {
    private WeaponItem weaponItem;

    private int price;
    public SellAction(WeaponItem weaponItem, int price){
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
        actor.removeWeaponFromInventory(weaponItem);
        RunesManager.subtractRunesValue(getPrice());
        message = actor + " successfully sold " + weaponItem.toString();
        return message;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
