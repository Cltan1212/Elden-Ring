package game.actors.enemies.skeletal;

import game.weapons.skeletalDropable.Grossmesser;

public class SkeletalMilitiaman extends SkeletalType{
    /**
     * Constructor. Skeletal Militiaman carries {@link Grossmesser} as their weapon.
     *
     * @see Grossmesser
     */
    public SkeletalMilitiaman() {
        super("Skeletal Militiaman",'I',788,25);
        this.addWeaponToInventory(new Grossmesser());
    }
}
