package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.actorActions.ConsumeAction;
import game.reset.Resettable;

public abstract class ConsumableItem extends Item implements Resettable, Consumable {

    public ConsumableItem(String name, char displayChar, boolean portable){
        super(name, displayChar, portable);
    }


    @Override
    public void consume(Actor actor) {

    }

    @Override
    public String toString(){
        return super.toString();
    }
    @Override
    public void reset(GameMap map){
    }
}
