package game.actions.tradingActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.runes.RunesManager;
import game.utils.Status;

public class sellAction extends Action {
    private WeaponItem weaponItem;

    private int price;
    public sellAction(WeaponItem weaponItem, int price){
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

        // remove the weapon from inventory
        actor.removeWeaponFromInventory(weaponItem);
        map.locationOf(actor).removeItem(weaponItem);

        // add runes to player
        RunesManager.addRunesValue(getPrice());

        // print the status
        message = actor + " successfully sold " + weaponItem.toString();

        return message;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " sell " + weaponItem.toString() + " with $" + price;
    }
}
