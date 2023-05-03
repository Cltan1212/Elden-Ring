package game.actors.enemies.water;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.RandomNumberGenerator;
import game.weapons.GiantCrayFishPincer;

/**
 * Class representing a physical Giant Cray Fish in the game world.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see WaterType
 * @see GiantCrayFishPincer
 */
public class GiantCrayFish extends WaterType {
    /**
     * Constructor.
     */
    public GiantCrayFish() {
        super("Giant Cray Fish", 'R',4803, 1);
        this.addWeaponToInventory(new GiantCrayFishPincer());
    }

    /**
     * Creates and returns an {@link IntrinsicWeapon}.
     *
     * By default, the GiantCrayFish 'slams' for 527 damage.
     *
     * @return a freshly-instantiated {@link IntrinsicWeapon}
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(527, "bites", 100);
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
