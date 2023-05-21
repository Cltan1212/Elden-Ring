package game.actors.enemies.water;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.RandomNumberGenerator;
import game.weapons.enemySpecial.GiantCrabSlam;

/**
 * Class representing a physical Giant Crab in the game world.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see WaterType
 * @see GiantCrabSlam
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
     * Creates and returns an {@link IntrinsicWeapon}.
     *
     * By default, the GiantCrab 'slams' for 208 damage.
     *
     * @return a freshly-instantiated {@link IntrinsicWeapon}
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 80);
    }

    /**
     * Generate a random amount of runes.
     *
     * @return an integer that represent an amount of runes
     * @see game.runes.RuneSource
     */
    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(318,4961);
    }
}
