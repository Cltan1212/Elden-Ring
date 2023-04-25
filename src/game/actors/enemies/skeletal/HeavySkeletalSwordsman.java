package game.actors.enemies.skeletal;

import game.actors.enemies.EnemyType;
import game.behaviours.WanderBehaviour;
import game.utils.Status;
import game.weapons.Grossmesser;

public class HeavySkeletalSwordsman extends Undead{
    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman",'q',153);

        // add capabilities
        this.addCapability(EnemyType.SKELETAL);
        this.addCapability(Status.HOSTILE_TO_DOG_TYPE_ENEMY);
        this.addCapability(Status.HOSTILE_TO_WATER_TYPE_ENEMY);

        // add weapon into weaponInventory
        this.addWeaponToInventory(new Grossmesser());

        // add behaviours this enemy can have
        this.behaviours.put(999, new WanderBehaviour());
    }

}
