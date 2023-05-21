package game.actors.enemies.enemyFactory;

import game.actors.enemies.dog.DogType;
import game.actors.enemies.dog.LoneWolf;
import game.actors.enemies.skeletal.HeavySkeletalSwordsman;
import game.actors.enemies.skeletal.SkeletalType;
import game.actors.enemies.sky.FlyingType;
import game.actors.enemies.sky.Owl;
import game.actors.enemies.water.GiantCrab;
import game.actors.enemies.water.WaterType;

public class NorthWestMapFactory implements EnemyFactory{
    /**
     *
     * @return the instance of {@link DogType} enemy on the north-west side of the map
     * @see LoneWolf
     */
    @Override
    public DogType createDog() {
        return new LoneWolf();
    }

    /**
     *
     * @return the instance of {@link SkeletalType} enemy on the north-west side of the map
     * @see HeavySkeletalSwordsman
     */
    @Override
    public SkeletalType createSkeletal() {
        return new HeavySkeletalSwordsman();
    }

    /**
     *
     * @return the instance of {@link WaterType} enemy on the north-west side of the map
     * @see GiantCrab
     */
    @Override
    public WaterType createWaterType() {
        return new GiantCrab();
    }

    /**
     *
     * @return the instance of {@link FlyingType} enemy on the north-west side of the map
     * @see Owl
     */
    @Override
    public FlyingType createFlyingType() {
        return new Owl();
    }
}
