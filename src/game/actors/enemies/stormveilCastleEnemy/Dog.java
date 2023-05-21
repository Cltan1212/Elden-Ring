package game.actors.enemies.stormveilCastleEnemy;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.enemies.dog.DogType;
import game.actors.enemies.stormveilCastleEnemy.StormveilCastleEnemy;
import game.behaviours.AttackBehaviour;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

public class Dog extends StormveilCastleEnemy{
    /**
     * Constructor.
     *
     */
    public Dog() {
        super("Dog",'a',104, 10);
    }

    /**
     * Creates and returns an {@link IntrinsicWeapon}.
     *
     * By default, the Dog 'bites' for 101 damage.
     *
     * @return a freshly-instantiated {@link IntrinsicWeapon}
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(101, "bites", 93);
    }

    /**
     * Generate a random amount of runes.
     *
     * @return an integer that represent an amount of runes
     * @see game.runes.RuneSource
     */
    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(52,1390);
    }
}
