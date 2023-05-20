package game.actors.enemies.skeletal;

import game.weapons.skeletalDropable.GraveScythe;

public class SkeletalMage extends SkeletalType{
    /**
     * Constructor. Skeletal Mage carries {@link GraveScythe} as its weapon.
     *
     * @see GraveScythe
     */
    public SkeletalMage() {
        super("Skeletal Mage",'|',677,21);
        this.addWeaponToInventory(new GraveScythe());
    }
}
