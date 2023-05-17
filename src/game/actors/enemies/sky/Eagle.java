package game.actors.enemies.sky;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.RandomNumberGenerator;

public class Eagle extends FlyingType {
    /**
     * Constructor.
     *
     */
    public Eagle() {
        super("Eagle",'Q',100,10);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(20, "bites", 99);
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(4,27);
    }
}

