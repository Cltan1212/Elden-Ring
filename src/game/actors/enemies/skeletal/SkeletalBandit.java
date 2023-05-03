package game.actors.enemies.skeletal;

import game.weapons.Scimitar;

/**
 * Class representing a physical Skeletal Bandit in the game world.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see SkeletalType
 */
public class SkeletalBandit extends SkeletalType {

    /**
     * Constructor. Skeletal Bandit carries Scimitar as their weapon.
     *
     * @see Scimitar
     */
    public SkeletalBandit() {
        super("Skeletal Bandit",'b',184, 27);
        this.addWeaponToInventory(new Scimitar());
    }
}
