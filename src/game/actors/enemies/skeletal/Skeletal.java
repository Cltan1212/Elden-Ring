package game.actors.enemies.skeletal;

import game.actors.enemies.Enemy;
import game.actors.enemies.EnemyType;

public abstract class Skeletal extends Enemy {

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Skeletal(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(EnemyType.SKELETAL);
    }
}
