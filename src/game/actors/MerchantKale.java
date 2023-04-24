package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.Purchasable;
import game.items.Sellable;

import java.util.ArrayList;

public class MerchantKale extends Actor {

    private static MerchantKale merchantKale;

    private final ArrayList<Purchasable> purchasableItemList;
    private final ArrayList<Sellable> sellableItemList;

    public MerchantKale() {
        super("Merchant Kale", 'K', 100);
        purchasableItemList = new ArrayList<>();
        sellableItemList = new ArrayList<>();
    }

    public static MerchantKale getInstance(){
        if (merchantKale == null){
            merchantKale = new MerchantKale();
        }
        return merchantKale;
    }

    public void registerPurchasableItem(Purchasable purchasableItem){
        purchasableItemList.add(purchasableItem);
    }

    public void registerSellableItem(Sellable sellableItem){
        sellableItemList.add(sellableItem);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actionList = new ActionList();

        // purchase weapon actions
        for (Purchasable purchasableItem : purchasableItemList){
            actionList.add(purchasableItem.createPurchaseAction());
        }

        // sell weapon actions
        for (WeaponItem weaponItem: otherActor.getWeaponInventory()){
            for (Sellable sellableItem : sellableItemList){
                if (weaponItem == sellableItem){
                    actionList.add(sellableItem.createSellAction());
                }
            }
        }
        return actionList;
    }
}
