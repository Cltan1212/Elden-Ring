package game.grounds.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.enemyFactory.EnemyFactory;
import game.actors.enemies.water.GiantCrab;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

public class PuddleOfWater extends SpawnGround {

    public PuddleOfWater(EnemyFactory enemyLocation) {
        super('~', 2, enemyLocation);
    }

    @Override
    public Enemy spawn(){
        return enemyFactory.createCrustracean(); // since PuddleOfWater spawn GiantCrab
    }

}
