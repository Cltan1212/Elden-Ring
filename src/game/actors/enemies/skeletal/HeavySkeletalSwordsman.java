package game.actors.enemies.skeletal;

import game.utils.RandomNumberGenerator;
import game.weapons.Grossmesser;

public class HeavySkeletalSwordsman extends SkeletalType {
    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman",'q',153);
        this.addWeaponToInventory(new Grossmesser());
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(35,892);
    }

}
