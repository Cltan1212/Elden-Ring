package game.actors.enemies.skeletal;

import game.weapons.skeletalDropable.Grossmesser;

/**
 * Class representing a physical Heavy Skeletal Swordsman in the game world.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
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
