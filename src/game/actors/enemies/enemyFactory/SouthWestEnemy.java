package game.actors.enemies.enemyFactory;

import game.actors.enemies.dog.DogType;
import game.actors.enemies.dog.GiantDog;
import game.actors.enemies.skeletal.SkeletalMage;
import game.actors.enemies.skeletal.SkeletalType;
import game.actors.enemies.sky.FlyingType;
import game.actors.enemies.sky.Eagle;
import game.actors.enemies.water.GiantCrayFish;
import game.actors.enemies.water.WaterType;

public class SouthWestEnemy implements EnemyFactory{
    /**
     *
     * @return the instance of {@link DogType} enemy on the south-west side of the map
     * @see GiantDog
     */
    @Override
    public DogType createDog() {
        return new GiantDog();
    }

    /**
     *
     * @return the instance of {@link SkeletalType} enemy on the south-west side of the map
     * @see SkeletalMage
     */
    @Override
    public SkeletalType createSkeletal() {
        return new SkeletalMage();
    }

    /**
     *
     * @return the instance of {@link WaterType} enemy on the south-west side of the map
     * @see GiantCrayFish
     */
    @Override
    public WaterType createWaterType() {
        return new GiantCrayFish();
    }

    /**
     *
     * @return the instance of {@link FlyingType} enemy on the south-west side of the map
     * @see Eagle
     */
    @Override
    public FlyingType createFlyingType() {
        return new Eagle();
    }
}
