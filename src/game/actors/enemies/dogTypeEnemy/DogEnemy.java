package game.actors.enemies.dogTypeEnemy;

import game.actors.enemies.Enemy;
import game.runes.RunesManager;
import game.utils.RandomNumberGenerator;

public abstract class DogEnemy extends Enemy {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public DogEnemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        RunesManager.getInstance().registerRuneSource(this);
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(55,1470);
    }
}
