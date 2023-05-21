package game.actors.enemies.enemyFactory;

import game.actors.enemies.dog.DogType;
import game.actors.enemies.dog.GiantDog;
import game.actors.enemies.skeletal.SkeletalBandit;
import game.actors.enemies.skeletal.SkeletalType;
import game.actors.enemies.sky.FlyingType;
import game.actors.enemies.sky.GiantBat;
import game.actors.enemies.water.GiantCrayFish;
import game.actors.enemies.water.WaterType;

public class NorthEastMapFactory implements EnemyFactory{
    /**
     *
     * @return the instance of {@link DogType} enemy on the north-east side of the map
     * @see GiantDog
     */
    @Override
    public DogType createDog() {
        return new GiantDog();
    }

    /**
     *
     * @return the instance of {@link SkeletalType} enemy on the north-east side of the map
     * @see SkeletalBandit
     */
    @Override
    public SkeletalType createSkeletal() {
        return new SkeletalBandit();
    }

    /**
     *
     * @return the instance of{@link WaterType} enemy on the north-east side of the map
     * @see GiantCrayFish
     */
    @Override
    public WaterType createWaterType() {
        return new GiantCrayFish();
    }

    /**
     *
     * @return the instance of{@link FlyingType} enemy on the north-east side of the map
     * @see GiantBat
     */
    @Override
    public FlyingType createFlyingType() {
        return new GiantBat();
    }
}
