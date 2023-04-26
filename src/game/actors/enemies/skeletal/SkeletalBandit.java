package game.actors.enemies.skeletal;

import game.utils.Status;
import game.weapons.Scimitar;

public class SkeletalBandit extends Skeletal {

    /**
     * Constructor.
     */
    public SkeletalBandit() {
        super("Skeletal Bandit", 'b', 184);
        this.addWeaponToInventory(new Scimitar());
//        this.addCapability(Status.SPINNING_ATTACK);
    }

    @Override
    public void reset() {

    }
}
