package game.actors.enemies.water;

import game.actors.enemies.Enemy;
import game.actors.enemies.EnemyType;

public abstract class WaterType extends Enemy {

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public WaterType(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(EnemyType.WATER);
    }
}
