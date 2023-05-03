package game.actors.enemies.skeletal;

import game.utils.RandomNumberGenerator;
import game.weapons.Grossmesser;

/**
 * Class representing a physical Heavy Skeletal Swordsman in the game world.
 * @see SkeletalType
 */

public class HeavySkeletalSwordsman extends SkeletalType {
    /**
     * Constructor. Heavy Skeletal Swordsman carries Grossmesser as their weapon.
     *
     * @see Grossmesser
     */
    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman",'q',153, 27);
        this.addWeaponToInventory(new Grossmesser());
    }

}
