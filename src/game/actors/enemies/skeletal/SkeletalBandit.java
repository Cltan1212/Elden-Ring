package game.actors.enemies.skeletal;

import game.weapons.Scimitar;

public class SkeletalBandit extends Skeletal {

    /**
     * Constructor.
     */
    public SkeletalBandit() {
        super("Skeletal Bandit", 'b', 184);
        this.addWeaponToInventory(new Scimitar());
    }

    @Override
    public void reset() {

    }
}
