package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.reset.Resettable;

public abstract class Enemies extends Actor implements Resettable{


    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Enemies(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);


    }

    @Override
    public void reset(GameMap map){
        map.removeActor(this);  // all enemies will be removed from the ground once reset

    }



}
