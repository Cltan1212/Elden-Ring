package game.actors.enemies.skeletalTypeEnemy;

import game.actors.enemies.Enemy;

public class SkeletalEnemy extends Enemy {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public SkeletalEnemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }
}
