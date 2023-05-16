package game.actors.traders;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.Purchasable;
import game.items.Sellable;
import game.utils.Status;
import game.weapons.*;

import java.util.ArrayList;

/**
 * Class representing the Merchant Kale. Merchant Kale is a trader in the game world.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see Actor
 * @see Sellable
 * @see Purchasable
 *
 */
public class MerchantKale extends Actor {

    /**
     * Constructor.
     */
    public MerchantKale() {
        super("Merchant Kale", 'K', 100);
        this.addCapability(Status.SELL);
    }

    /**
     * Merchant Kale always do nothing in each turn.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    /**
     * Merchant Kale allows other actor to purchase or sell their weapon inside their weapon inventory.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
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
        return actionList;
    }
}
