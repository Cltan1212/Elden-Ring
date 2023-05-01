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
     * Generate a random amount of runes.
     *
     * @return an integer that represent an amount of runes
     */
    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(313,1808);
    }
}
