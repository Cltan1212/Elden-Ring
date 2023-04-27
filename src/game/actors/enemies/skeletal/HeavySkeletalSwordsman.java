package game.actors.enemies.skeletal;

import game.actors.enemies.EnemyType;
import game.behaviours.WanderBehaviour;
import game.utils.RandomNumberGenerator;
import game.utils.Status;
import game.weapons.Grossmesser;

public class HeavySkeletalSwordsman extends Undead{
    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman",'q',153);
        this.addWeaponToInventory(new Grossmesser());
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(35,892);
    }

}
