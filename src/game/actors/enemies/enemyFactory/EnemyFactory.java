package game.actors.enemies.enemyFactory;

import game.actors.enemies.dog.DogType;
import game.actors.enemies.skeletal.SkeletalType;
import game.actors.enemies.water.WaterType;

public interface EnemyFactory {
    public DogType createDog();
    public SkeletalType createUndead();
    public WaterType createCrustracean();
}
