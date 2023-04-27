package game.actors.enemies.water;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.RandomNumberGenerator;
import game.weapons.GiantCrabSlam;

public class GiantCrab extends Crustracean{
    public GiantCrab() {
        super("Giant Crab",'C',407);
        this.addWeaponToInventory(new GiantCrabSlam());
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(318,4961);
    }
}
