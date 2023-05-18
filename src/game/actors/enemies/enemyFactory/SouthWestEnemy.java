package game.actors.enemies.enemyFactory;

import game.actors.enemies.dog.DogType;
import game.actors.enemies.dog.GiantDog;
import game.actors.enemies.skeletal.SkeletalMage;
import game.actors.enemies.skeletal.SkeletalType;
import game.actors.enemies.sky.FlyingType;
import game.actors.enemies.sky.Eagle;
import game.actors.enemies.water.GiantCrab;
import game.actors.enemies.water.WaterType;

public class SouthWestEnemy implements EnemyFactory{
    @Override
    public DogType createDog() {
        return new GiantDog();
    }

    @Override
    public SkeletalType createSkeletal() {
        return new SkeletalMage();
    }

    @Override
    public WaterType createWaterType() {
        return new GiantCrab();
    }

    @Override
    public FlyingType createFlyingType() {
        return new Eagle();
    }
}
