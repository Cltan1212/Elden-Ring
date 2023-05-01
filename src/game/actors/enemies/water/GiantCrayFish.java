package game.actors.enemies.water;

import game.utils.RandomNumberGenerator;
import game.weapons.GiantCrabSlam;

/**
 * Class representing a physical Giant Cray Fish in the game world.
 */
public class GiantCrayFish extends WaterType {
    /**
     * Constructor.
     */
    public GiantCrayFish() {
        super("Giant Cray Fish", 'R',4803, 1);
        this.addWeaponToInventory(new GiantCrabSlam());
    }

    /**
     * Generate a random amount of runes.
     *
     * @return an integer that represent an amount of runes
     */
    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(500,2374);
    }
}
