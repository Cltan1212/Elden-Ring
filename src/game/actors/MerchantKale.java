package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.runesActions.PurchaseAction;
import game.actions.runesActions.SellAction;
import game.items.Purchasable;
import game.items.Sellable;
import game.utils.Status;
import game.weapons.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MerchantKale extends Actor {

    private final ArrayList<Sellable> sellableItemList;

    public MerchantKale() {
        super("Merchant Kale", 'K', 100);
        sellableItemList = new ArrayList<>();
        sellableItemList.add(new Club());
        sellableItemList.add(new GreatKnife());
        sellableItemList.add(new Uchigatana());
        sellableItemList.add(new Grossmesser());
        sellableItemList.add(new Scimitar());
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actionList = new ActionList();
        ArrayList<Purchasable> purchasableItemList = new ArrayList<>();
        purchasableItemList.add(new Club());
        purchasableItemList.add(new GreatKnife());
        purchasableItemList.add(new Uchigatana());
        purchasableItemList.add(new Scimitar());

        // purchase weapon actions
        for (Purchasable purchasableItem : purchasableItemList){
            actionList.add(purchasableItem.createPurchaseAction());
        }

        // sell weapon actions
        for (WeaponItem weaponItem: otherActor.getWeaponInventory()){
            for (Sellable sellableItem : sellableItemList){
                if (weaponItem.toString().equals(sellableItem.toString())){
                    actionList.add(sellableItem.createSellAction());
                }
            }
        }
        return actionList;
    }
}
