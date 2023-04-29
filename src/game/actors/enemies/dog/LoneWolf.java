package game.actors.enemies.dog;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.RandomNumberGenerator;
import game.behaviours.WanderBehaviour;

/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class LoneWolf extends DogType {

    /**
     * Constructor.
     */
    public LoneWolf() {
        super("Lone Wolf", 'h', 102, 33);
        this.behaviours.put(999, new WanderBehaviour());
    }

    /**
     * Creates and returns an intrinsic weapon.
     *
     * By default, the LoneWolf 'bites' for 95 damage.
     *
     * @return a freshly-instantiated IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }

    /**
     * Generate a random amount of runes.
     *
     * @return an integer that represent an amount of runes
     */
    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(55,1470);
    }
}
