package game.actors.enemies.sky;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.RandomNumberGenerator;

public class Owl extends FlyingType {
    /**
     * Constructor.
     *
     */
    public Owl() {
        super("Owl",'W',88,10);
    }

    /**
     * Creates and returns an {@link IntrinsicWeapon}.
     *
     * By default, the Owl 'bites' for 20 damage.
     *
     * @return a freshly-instantiated {@link IntrinsicWeapon}
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(20, "bites", 99);
    }

    /**
     * Generate a random amount of runes.
     *
     * @return an integer that represent an amount of runes
     * @see game.runes.RuneSource
     */
    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(4,16);
    }
}
