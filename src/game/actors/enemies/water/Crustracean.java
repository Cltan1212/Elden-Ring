package game.actors.enemies.water;

import game.actors.enemies.Enemy;
import game.utils.RandomNumberGenerator;

public abstract class Crustracean extends Enemy {

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Crustracean(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(318,4961);
    }

}
