package game.actors.enemies.waterTypeEnemy;

import game.actors.enemies.Enemy;
import game.runes.RunesManager;
import game.utils.RandomNumberGenerator;

public abstract class WaterEnemy extends Enemy {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public WaterEnemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        RunesManager.getInstance().registerRuneSource(this);
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(318,4961);
    }
}
