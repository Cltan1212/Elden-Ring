package game.actions.actorActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Consumable;
import game.items.ConsumableItem;
import game.utils.FancyMessage;
import game.utils.Status;

public class ConsumeAction extends Action {
    private final ConsumableItem item;

    public ConsumeAction(ConsumableItem consumeItem){
        this.item = consumeItem;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String returnString = item.consume(actor);
        return returnString;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + item;
    }

    public String hotkey() {
        return "f";
    }
}
