package game.grounds.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.skeletal.HeavySkeletalSwordsman;
import game.actors.enemies.water.GiantCrab;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

public class PuddleOfWater extends SpawnGround {
    public PuddleOfWater() {
        super('~', 2);
    }


}
