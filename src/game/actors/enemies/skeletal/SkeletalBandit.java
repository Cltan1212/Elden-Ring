package game.actors.enemies.skeletal;

import game.weapons.Scimitar;

/**
 * Class representing a physical Skeletal Bandit in the game world.
 */
public class SkeletalBandit extends SkeletalType {

    /**
     * Constructor.
     */
    public SkeletalBandit() {
        super("Skeletal Bandit",'b',184, 27);
        this.addWeaponToInventory(new Scimitar());
    }
}
