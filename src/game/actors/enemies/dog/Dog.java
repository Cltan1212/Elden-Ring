package game.actors.enemies.dog;

import game.actors.enemies.Enemy;
import game.runes.RunesManager;
import game.utils.RandomNumberGenerator;

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
        RunesManager.getInstance().registerRuneSource(this);
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(55,1470);
    }
}
