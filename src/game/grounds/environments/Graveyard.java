package game.grounds.environments;

import game.actors.enemies.Enemy;
import game.actors.enemies.enemyFactory.EnemyFactory;

public class Graveyard extends SpawnGround {

    public Graveyard(EnemyFactory enemyLocation) {
        super('n', enemyLocation);
    }

    @Override
    public Enemy spawn(){
        return enemyFactory.createSkeletal(); // since Graveyard spone HeavySkeletalSwordsman
    }

}
