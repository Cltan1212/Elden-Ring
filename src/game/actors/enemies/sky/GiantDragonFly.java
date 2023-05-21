package game.actors.enemies.sky;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.RandomNumberGenerator;
import game.weapons.enemySpecial.GiantDragonFlyHead;

public class GiantDragonFly extends FlyingType {
    /**
     * Constructor.
     *
     */
    public GiantDragonFly() {
        super("Giant Dragon Fly",'F',78,10);
        this.addWeaponToInventory(new GiantDragonFlyHead());
    }

    /**
     * Creates and returns an {@link IntrinsicWeapon}.
     *
     * By default, the Giant Dragon Fly 'slams' for 208 damage.
     *
     * @return a freshly-instantiated {@link IntrinsicWeapon}
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }

    /**
     * Generate a random amount of runes.
     *
     * @return an integer that represent an amount of runes
     * @see game.runes.RuneSource
     */
    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(4,41);
    }
}
