package game.actors.enemies.sky;

import game.actors.enemies.Enemy;

public abstract class BirdType extends Enemy {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     * @param spawnChance the spawning rate
     */
    public BirdType(String name, char displayChar, int hitPoints, int spawnChance) {
        super(name, displayChar, hitPoints, spawnChance);
    }

    @Override
    public int generateRunes() {
        return 0;
    }
}
