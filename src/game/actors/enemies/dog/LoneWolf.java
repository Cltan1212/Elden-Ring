package game.actors.enemies.dog;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.RandomNumberGenerator;
import game.behaviours.WanderBehaviour;

/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class LoneWolf extends DogType {

    public LoneWolf() {
        super("Lone Wolf", 'h', 102);
        this.behaviours.put(999, new WanderBehaviour());
    }


    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(55,1470);
    }
}
