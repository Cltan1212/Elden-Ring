package game.actors.enemies.stormveilCastleEnemy;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.RandomNumberGenerator;

public class Dog extends StormveilCastleEnemy {
    /**
     * Constructor.
     *
     */
    public Dog() {
        super("Dog",'a',104, 10);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(101, "bites", 93);
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(52,1390);
    }
}
