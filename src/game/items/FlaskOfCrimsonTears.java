package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.reset.Resettable;

public class FlaskOfCrimsonTears extends Item implements Resettable, Consumable{

    private static final int NUMBERS_CAN_CONSUME = 2;

    public FlaskOfCrimsonTears() {
        super("Flask Of Crimson Tears",'f',false);
    }

    @Override
    public void consume() {
        // TODO: add player's health 250
        // TODO: if numbers_can_consume == 0, removeItem from inventory
    }

    @Override
    public void reset() {
        // TODO: reset the total amount
    }
}
