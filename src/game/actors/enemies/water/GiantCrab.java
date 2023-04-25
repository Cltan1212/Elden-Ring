package game.actors.enemies.water;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.enemies.EnemyType;
import game.behaviours.WanderBehaviour;
import game.utils.Status;

public class GiantCrab extends Crustracean{
    public GiantCrab() {
        super("Giant Crab",'C',407);

        // add capabilities
        this.addCapability(EnemyType.WATER);
        this.addCapability(Status.HOSTILE_TO_SKELETAL_TYPE_ENEMY);
        this.addCapability(Status.HOSTILE_TO_DOG_TYPE_ENEMY);

        // add behaviours
        this.behaviours.put(999, new WanderBehaviour());
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }

}
