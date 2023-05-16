package game.grounds.environments;

import game.actors.enemies.Enemy;
import game.actors.enemies.enemyFactory.EnemyFactory;

public class ThunderStorm extends SpawnGround{
    public ThunderStorm(EnemyFactory enemyFactory) {
        super('%', enemyFactory);
    }

    @Override
    public Enemy spawn(){
        return enemyFactory.createBirdType();}
}
