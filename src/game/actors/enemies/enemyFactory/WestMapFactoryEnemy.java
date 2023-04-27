package game.actors.enemies.enemyFactory;

import game.actors.enemies.dog.DogType;
import game.actors.enemies.dog.LoneWolf;
import game.actors.enemies.skeletal.HeavySkeletalSwordsman;
import game.actors.enemies.skeletal.SkeletalType;
import game.actors.enemies.water.WaterType;
import game.actors.enemies.water.GiantCrab;

public class WestMapFactoryEnemy implements EnemyFactory{
    @Override
    public DogType createDog() {
        return new LoneWolf();
    }

    @Override
    public SkeletalType createUndead() {
        return new HeavySkeletalSwordsman();
    }

    @Override
    public WaterType createCrustracean() {
        return new GiantCrab();
    }
}
