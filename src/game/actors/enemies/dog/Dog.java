package game.actors.enemies.dog;

import game.actors.enemies.Enemy;
import game.actors.enemies.EnemyType;
import game.behaviours.Behaviour;

import java.util.HashMap;
import java.util.Map;

public abstract class Dog extends Enemy {



    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Dog(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(EnemyType.DOG);
    }

    @Override
    public void reset() {

    }
}
