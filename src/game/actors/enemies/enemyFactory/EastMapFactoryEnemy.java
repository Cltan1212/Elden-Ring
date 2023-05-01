package game.actors.enemies.enemyFactory;

import game.actors.enemies.dog.DogType;
import game.actors.enemies.dog.GiantDog;
import game.actors.enemies.skeletal.SkeletalBandit;
import game.actors.enemies.skeletal.SkeletalType;
import game.actors.enemies.water.WaterType;
import game.actors.enemies.water.GiantCrayFish;

/**
 * A class that creates different type of enemies on east side of the map.
 */
public class EastMapFactoryEnemy implements EnemyFactory{

    /**
     *
     * @return the instance of DogType enemy on the east side of the map
     */
    @Override
    public DogType createDog() {
        return new GiantDog();
    }

    /**
     *
     * @return the instance of SkeletalType enemy on the east side of the map
     */
    @Override
    public SkeletalType createSkeletal() {
        return new SkeletalBandit();
    }

    /**
     *
     * @return the instance of WaterType enemy on the east side of the map
     */
    @Override
    public WaterType createWaterType() {
        return new GiantCrayFish();
    }

}
