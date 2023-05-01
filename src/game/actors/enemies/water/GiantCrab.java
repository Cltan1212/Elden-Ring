package game.actors.enemies.water;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.RandomNumberGenerator;
import game.weapons.GiantCrabSlam;

/**
 * Class representing a physical Giant Crab in the game world.
 */
public class GiantCrab extends WaterType {
    /**
     * Constructor.
     */
    public GiantCrab() {
        super("Giant Crab",'C',407, 2);
        this.addWeaponToInventory(new GiantCrabSlam());
    }

    /**
     * Generate a random amount of runes.
     *
     * @return an integer that represent an amount of runes
     */
    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(318,4961);
    }
}
