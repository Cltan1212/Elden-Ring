package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.actorActions.ConsumeAction;
import game.reset.ResetManager;
import game.reset.Resettable;

/**
 * Abstract class representing a Consumable Item. It extends the Item class and implements the Consumable and Resettable interfaces.
 * It provides a default implementation of the consume() method and overrides the reset() method to do nothing.
 */
public abstract class ConsumableItem extends Item implements Resettable, Consumable {

    protected int maximumUse;
    protected int remainingConsume;
    /**
     * Constructor.
     *
     * @param name         a String, the name of this ConsumableItem
     * @param displayChar  a char, the character to use to represent this ConsumableItem when it is on the ground
     * @param portable     a boolean, indicating whether this ConsumableItem is portable or not
     */
    public ConsumableItem(String name, char displayChar, boolean portable){
        super(name, displayChar, portable);
        this.addAction(new ConsumeAction(this));
        ResetManager.getInstance().registerResettable(this);
    }

    /**
     * A method that reset the remaining consume to maximum consume
     * @param map the map in which the Flask Of Crimson is on
     */
    @Override
    public void reset(GameMap map){
        this.remainingConsume = maximumUse;
    }
}
