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
    /**
     *
     * @return the instance of {@link DogType} enemy on the south-east side of the map
     * @see LoneWolf
     */
    @Override
    public DogType createDog() {
        return new LoneWolf();
    }

    /**
     *
     * @return the instance of {@link SkeletalType} enemy on the south-east side of the map
     * @see SkeletalMilitiaman
     */
    @Override
    public SkeletalType createSkeletal() {
        return new SkeletalMilitiaman();
    }

    /**
     *
     * @return the instance of {@link WaterType} enemy on the south-east side of the map
     * @see GiantCrab
     */
    @Override
    public WaterType createWaterType() {
        return new GiantCrab();
    }

    /**
     *
     * @return the instance of {@link FlyingType} enemy on the south-east side of the map
     * @see GiantDragonFly
     */
    @Override
    public FlyingType createFlyingType() {
        return new GiantDragonFly();
    }
}
