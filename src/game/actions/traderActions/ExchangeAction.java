package game.actions.traderActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.trading.Exchangeable;

public class ExchangeAction extends Action {
    private Exchangeable exchangeableItem;
    private WeaponItem receiveItem;
    public ExchangeAction(Exchangeable exchangeableItem, WeaponItem receiveItem){
        this.exchangeableItem = exchangeableItem;
        this.receiveItem = receiveItem;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        String message = "";
        exchangeableItem.createExchangeAction(actor, receiveItem);

        message = actor + " exchanged " + exchangeableItem + " for " + receiveItem;

        return message;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " exchanges " + exchangeableItem + " for " + receiveItem;
    }
}
