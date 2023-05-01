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
     * @return the instance of DogType enemy
     */
    DogType createDog();

    /**
     *
     * @return the instance of SkeletalType enemy
     */
    SkeletalType createSkeletal();

    /**
     *
     * @return the instance of WaterType enemy
     */
    WaterType createWaterType();
}
