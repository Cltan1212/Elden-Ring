package game.actors.enemies.enemySpawn;

import game.actors.enemies.dogTypeEnemy.DogEnemy;
import game.actors.enemies.dogTypeEnemy.LoneWolf;
import game.actors.enemies.skeletalTypeEnemy.HeavySkeletalSwordsman;
import game.actors.enemies.skeletalTypeEnemy.SkeletalEnemy;
import game.actors.enemies.waterTypeEnemy.GiantCrab;
import game.actors.enemies.waterTypeEnemy.WaterEnemy;

public class EnemyWest implements EnemyLocation{

    @Override
    public DogEnemy createDog() {
        return new LoneWolf();
    }

    @Override
    public SkeletalEnemy createSkeletal() {
        return new HeavySkeletalSwordsman();
    }

    @Override
    public WaterEnemy createWater() {
        return new GiantCrab();
    }
}
