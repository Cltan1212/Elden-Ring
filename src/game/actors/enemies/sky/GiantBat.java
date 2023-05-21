package game.actors.enemies.sky;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.RandomNumberGenerator;

public class GiantBat extends FlyingType {
    /**
     * Constructor.
     *
     */
    public GiantBat() {
        super("Giant Bat",'^',143,10);
    }

    /**
     * Creates and returns an {@link IntrinsicWeapon}.
     *
     * By default, the Giant Bat 'poise' for 52 damage.
     *
     * @return a freshly-instantiated {@link IntrinsicWeapon}
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(52, "poise", 92);
    }

    /**
     * Generate a random amount of runes.
     *
     * @return an integer that represent an amount of runes
     * @see game.runes.RuneSource
     */
    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(47,887);
    }
}
