package game.actors.enemies.dog;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.utils.RandomNumberGenerator;
import game.behaviours.WanderBehaviour;
import game.utils.Status;

/**
 * BEHOLD, DOG!
 *
 * @author Adrian Kristanto
 * Modified by: Tan Chun Ling, Wan Jack Liang, King Jean Lynn
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
