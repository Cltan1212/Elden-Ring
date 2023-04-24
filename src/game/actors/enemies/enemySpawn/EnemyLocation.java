package game.actors.enemies.enemySpawn;

import game.actors.enemies.dogTypeEnemy.DogEnemy;
import game.actors.enemies.skeletalTypeEnemy.SkeletalEnemy;
import game.actors.enemies.waterTypeEnemy.WaterEnemy;

public interface EnemyLocation {
    public DogEnemy createDog();
    public SkeletalEnemy createSkeletal();
    public WaterEnemy createWater();
}
