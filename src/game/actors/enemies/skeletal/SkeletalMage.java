package game.actors.enemies.skeletal;

import game.weapons.skeletalDropable.GraveScythe;

public class SkeletalMage extends SkeletalType{
    /**
     * Constructor.
     */
    public SkeletalMage() {
        super("Skeletal Mage",'|',677,21);
        this.addWeaponToInventory(new GraveScythe());
    }
}

