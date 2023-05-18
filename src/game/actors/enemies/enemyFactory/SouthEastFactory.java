package game.actors.enemies.enemyFactory;

import game.actors.enemies.dog.DogType;
import game.actors.enemies.dog.LoneWolf;
import game.actors.enemies.skeletal.SkeletalMilitiaman;
import game.actors.enemies.skeletal.SkeletalType;
import game.actors.enemies.sky.FlyingType;
import game.actors.enemies.sky.GiantDragonFly;
import game.actors.enemies.water.GiantCrab;
import game.actors.enemies.water.WaterType;

public class SouthEastFactory implements EnemyFactory{
    @Override
    public DogType createDog() {
        return new LoneWolf();
    }

    @Override
    public SkeletalType createSkeletal() {
        return new SkeletalMilitiaman();
    }

    @Override
    public WaterType createWaterType() {
        return new GiantCrab();
    }

    @Override
    public FlyingType createFlyingType() {
        return new GiantDragonFly();
    }
}
