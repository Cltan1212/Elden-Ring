package game.actors.enemies.dog;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.RandomNumberGenerator;
import game.weapons.GiantDogHead;

/**
 * Class representing a physical GiantDog in the game world.
 */
public class GiantDog extends DogType {

    /**
     * Constructor.
     */
    public GiantDog() {
        super("Giant Dog",'G',693, 4);
        this.addWeaponToInventory(new GiantDogHead());
    }

    /**
     * Creates and returns an {@link IntrinsicWeapon}.
     *
     * By default, the GiantDog 'slams' for 208 damage.
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
     */
    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(313,1808);
    }
}
