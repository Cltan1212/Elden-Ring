package game.item;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.reset.Resettable;

public abstract class Consumable extends Item implements Resettable {
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public Consumable(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
    }

    public abstract void consumeItem(Actor actor);


}
