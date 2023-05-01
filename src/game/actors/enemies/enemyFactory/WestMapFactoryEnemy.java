package game.actors.enemies.enemyFactory;

import game.actors.enemies.dog.DogType;
import game.actors.enemies.dog.LoneWolf;
import game.actors.enemies.skeletal.HeavySkeletalSwordsman;
import game.actors.enemies.skeletal.SkeletalType;
import game.actors.enemies.water.WaterType;
import game.actors.enemies.water.GiantCrab;

/**
 * A class that creates different type of enemies on west side of the map.
 */
public class WestMapFactoryEnemy implements EnemyFactory{

    /**
     *
     * @return the instance of DogType enemy on the west side of the map
     */
    @Override
    public DogType createDog() {
        return new LoneWolf();
    }

    /**
     *
     * @return the instance of SkeletalType enemy on the west side of the map
     */
    @Override
    public SkeletalType createSkeletal() {
        return new HeavySkeletalSwordsman();
    }

    /**
     *
     * @return the instance of WaterType enemy on the west side of the map
     */
    @Override
    public WaterType createWaterType() {
        return new GiantCrab();
    }
}
