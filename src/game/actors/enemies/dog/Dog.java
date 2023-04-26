package game.actors.enemies.dog;

import game.actors.enemies.Enemy;
import game.actors.enemies.EnemyType;
import game.runes.RunesManager;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

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
        this.addCapability(Status.HOSTILE_TO_WATER_TYPE_ENEMY);
        this.addCapability(Status.HOSTILE_TO_SKELETAL_TYPE_ENEMY);
        RunesManager.getInstance().registerRuneSource(this);
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(55,1470);
    }
}
