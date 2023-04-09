package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class PurchaseAction extends Action {
    @Override
    public String execute(Actor actor, GameMap map) {
        // TODO: check the item canPurchase -> add item into inventory
        //  -> callRunesManager to subtract
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
