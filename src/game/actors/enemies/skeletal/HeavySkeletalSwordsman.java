package game.actors.enemies.skeletal;

import game.utils.RandomNumberGenerator;
import game.weapons.Grossmesser;

/**
 * Class representing a physical Heavy Skeletal Swordsman in the game world.
 */

public class HeavySkeletalSwordsman extends SkeletalType {
    /**
     * Constructor.
     */
    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman",'q',153, 27);
        this.addWeaponToInventory(new Grossmesser());
    }

}
