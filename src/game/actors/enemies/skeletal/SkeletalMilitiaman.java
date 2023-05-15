package game.actors.enemies.skeletal;

import game.weapons.skeletalDropable.Grossmesser;

public class SkeletalMilitiaman extends SkeletalType{
    /**
     * Constructor.
     */
    public SkeletalMilitiaman() {
        super("Skeletal Militiaman",'I',788,25);
        this.addWeaponToInventory(new Grossmesser());
    }
}
