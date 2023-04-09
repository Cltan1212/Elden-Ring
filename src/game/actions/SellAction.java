package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class SellAction extends Action {
    @Override
    public String execute(Actor actor, GameMap map) {
        // TODO: check if the item is sellable (has capabilities) -> call RunesManager to subtract
        //  -> remove item from inventory
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
