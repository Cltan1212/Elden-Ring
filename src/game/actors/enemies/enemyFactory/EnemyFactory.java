package game.actors.enemies.enemyFactory;

import game.actors.enemies.dog.DogType;
import game.actors.enemies.skeletal.SkeletalType;
import game.actors.enemies.sky.FlyingType;
import game.actors.enemies.water.WaterType;

/**
 * An interface for creating different type of enemies.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 */
public interface EnemyFactory {
    /**
     *
     * @return the instance of {@link DogType} enemy
     */
    DogType createDog();

    /**
     *
     * @return the instance of {@link SkeletalType} enemy
     */
    SkeletalType createSkeletal();

    /**
     *
     * @return the instance of {@link WaterType} enemy
     */
    WaterType createWaterType();

    FlyingType createFlyingType();
}
