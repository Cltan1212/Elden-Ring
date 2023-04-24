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
    private ConsumableItem item;

    public ConsumeAction(ConsumableItem consumeItem){
        this.item = consumeItem;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        item.consume(actor);
        return actor + " consumed " + item;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + item;
    }

//    public String hotkey() {
//        return "f";
//    }
}
