package game.actions.actorActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Consumable;
import game.items.ConsumableItem;

/**
 * A class that represents the action of an actor consuming a consumable item.
 * This action allows the actor to consume the item, which triggers its effect.
 * @see Action
 */
public class ConsumeAction extends Action {
    /**
     * The {@link Consumable} item that will be consumed.
     */
    private Consumable item;

    /**
     * Constructor for ConsumeAction class.
     *
     * @param consumeItem The {@link Consumable} item that will be consumed.
     */
    public ConsumeAction(Consumable consumeItem){
        this.item = consumeItem;
    }

    /**
     * Execute the ConsumeAction.
     * The actor consumes the item, which triggers its effect.
     *
     * @param actor The {@link Actor} performing the action.
     * @param map The {@link GameMap} the actor is on.
     * @return A string describing the outcome of the action.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        item.consume(actor);
        return actor + " consumed " + item;
    }

    /**
     * Return a string describing this action in the menu.
     *
     * @param actor The {@link Actor} performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + item;
    }
}

