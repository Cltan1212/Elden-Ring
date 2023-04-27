package game.actors.enemies.enemyFactory;

import game.actors.enemies.dog.DogType;
import game.actors.enemies.dog.GiantDog;
import game.actors.enemies.skeletal.SkeletalBandit;
import game.actors.enemies.skeletal.SkeletalType;
import game.actors.enemies.water.WaterType;
import game.actors.enemies.water.GiantCrayFish;

public class EastMapFactoryEnemy implements EnemyFactory{
    @Override
    public DogType createDog() {
        return new GiantDog();
    }

    @Override
    public SkeletalType createUndead() {
        return new SkeletalBandit();
    }

    @Override
    public WaterType createCrustracean() {
        return new GiantCrayFish();
    }

}
