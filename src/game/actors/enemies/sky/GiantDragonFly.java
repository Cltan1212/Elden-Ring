package game.actors.enemies.sky;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.RandomNumberGenerator;
import game.weapons.GiantDragonFlyHead;

public class GiantDragonFly extends BirdType {
    /**
     * Constructor.
     *
     */
    public GiantDragonFly() {
        super("Giant Dragon Fly",'F',78,10);
        this.addWeaponToInventory(new GiantDragonFlyHead());
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(4,41);
    }
}
