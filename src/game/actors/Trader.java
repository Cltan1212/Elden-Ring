package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.tradingActions.purchaseAction;
import game.actions.tradingActions.sellAction;
import game.utils.Status;
import game.weapons.Club;
import game.weapons.GreatKnife;
import game.weapons.Grossmesser;
import game.weapons.Uchigatana;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Trader extends Actor {

    private static final HashMap<WeaponItem, Integer> sellItem = new HashMap<>();
    private static final HashMap<WeaponItem, Integer> acceptedItem = new HashMap<>();

    public Trader(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);

        // the items that can be purchased and sold by Merchant Kale
//        if (name.equals("Merchant Kale")){
//            sellItem.put(new Uchigatana(), 5000);
//            sellItem.put(new GreatKnife(), 3500);
//            sellItem.put(new Club(), 600);
//            acceptedItem.put(new Uchigatana(), 500);
//            acceptedItem.put(new GreatKnife(), 350);
//            acceptedItem.put(new Club(), 100);
//            acceptedItem.put(new Grossmesser(), 100);
//        }
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actionList = new ActionList();
        if (otherActor.hasCapability(Status.BUYING)){
            for (Map.Entry<WeaponItem, Integer> weaponItem: sellItem.entrySet()){
                actionList.add(new purchaseAction(weaponItem.getKey(), weaponItem.getValue()));
            }
        }
        if (otherActor.hasCapability(Status.SELLING)){
            for (Map.Entry<WeaponItem, Integer> weaponItem: acceptedItem.entrySet()){
                if (otherActor.getWeaponInventory().contains(weaponItem.getKey())){
                    actionList.add(new sellAction(weaponItem.getKey(), weaponItem.getValue()));
                }
            }
        }
        return actionList;
    }
}
