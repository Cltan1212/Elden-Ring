package game.grounds.environments;

import game.actors.enemies.Enemy;
import game.actors.enemies.enemyFactory.EnemyFactory;

public class PuddleOfWater extends SpawnGround {

    public PuddleOfWater(EnemyFactory enemyLocation) {
        super('~', enemyLocation);
    }

    @Override
    public Enemy spawn(){
        return enemyFactory.createWaterType(); // since PuddleOfWater spawn GiantCrab
    }

}
