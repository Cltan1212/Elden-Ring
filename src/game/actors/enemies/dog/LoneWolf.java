package game.actors.enemies.dog;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.RandomNumberGenerator;
import game.behaviours.WanderBehaviour;

/**
 * BEHOLD, DOG!
 *
 * @author Adrian Kristanto
 * Modified by:
 * @see DogType
 */
public class LoneWolf extends DogType {

    /**
     * Constructor.
     *
     * @see WanderBehaviour
     */
    public LoneWolf() {
        super("Lone Wolf", 'h', 102, 33);
        this.behaviours.put(999, new WanderBehaviour());
    }

    /**
     * Creates and returns an {@link IntrinsicWeapon}.
     *
     * By default, the LoneWolf 'bites' for 95 damage.
     *
     * @return a freshly-instantiated {@link IntrinsicWeapon}
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }

    /**
     * Generate a random amount of runes.
     *
     * @return an integer that represent an amount of runes
     * @see game.runes.RuneSource
     */
    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(55,1470);
    }
}
