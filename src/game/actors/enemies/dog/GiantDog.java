package game.actors.enemies.dog;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.utils.RandomNumberGenerator;
import game.utils.Status;
import game.weapons.enemySpecial.GiantDogHead;

/**
 * Class representing a physical GiantDog in the game world.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see DogType
 */
public class GiantDog extends DogType {

    /**
     * Constructor.
     */
    public GiantDog() {
        super("Giant Dog",'G',60, 4);
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
     * @see game.runes.RuneSource
     */
    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(313,1808);
    }
}
