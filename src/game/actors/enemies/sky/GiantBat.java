package game.actors.enemies.sky;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.RandomNumberGenerator;

public class GiantBat extends BirdType {
    /**
     * Constructor.
     *
     */
    public GiantBat() {
        super("Giant Bat",'^',143,10);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(30, "poise", 92);
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(47,887);
    }
}
