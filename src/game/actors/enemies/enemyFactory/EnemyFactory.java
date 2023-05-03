package game.actors.enemies.enemyFactory;

import game.actors.enemies.dog.DogType;
import game.actors.enemies.skeletal.SkeletalType;
import game.actors.enemies.water.WaterType;

/**
 * An interface for creating different type of enemies.
 *
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
}
