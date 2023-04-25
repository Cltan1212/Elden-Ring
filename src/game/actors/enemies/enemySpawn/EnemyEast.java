package game.actors.enemies.enemySpawn;

import game.actors.enemies.dogTypeEnemy.DogEnemy;
import game.actors.enemies.dogTypeEnemy.GiantDog;
import game.actors.enemies.skeletalTypeEnemy.SkeletalBandit;
import game.actors.enemies.skeletalTypeEnemy.SkeletalEnemy;
import game.actors.enemies.waterTypeEnemy.GiantCrayFish;
import game.actors.enemies.waterTypeEnemy.WaterEnemy;

public class EnemyEast implements EnemyLocation{
    @Override
    public DogEnemy createDog() {
        return new GiantDog();
    }

    @Override
    public SkeletalEnemy createSkeletal() {
        return new SkeletalBandit();
    }

    @Override
    public WaterEnemy createWater() {
        return new GiantCrayFish();
    }
}
