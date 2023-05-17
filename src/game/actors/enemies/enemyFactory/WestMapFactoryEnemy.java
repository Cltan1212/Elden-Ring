//package game.actors.enemies.enemyFactory;
//
//import game.actors.enemies.dog.DogType;
//import game.actors.enemies.dog.LoneWolf;
//import game.actors.enemies.skeletal.HeavySkeletalSwordsman;
//import game.actors.enemies.skeletal.SkeletalType;
//import game.actors.enemies.water.WaterType;
//import game.actors.enemies.water.GiantCrab;
//
///**
// * A class that creates different type of enemies on west side of the map.
// * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
// * @see EnemyFactory
// */
//public class WestMapFactoryEnemy implements EnemyFactory{
//
//    /**
//     *
//     * @return the instance of {@link DogType} enemy on the west side of the map
//     * @see LoneWolf
//     */
//    @Override
//    public DogType createDog() {
//        return new LoneWolf();
//    }
//
//    /**
//     *
//     * @return the instance of {@link SkeletalType} enemy on the west side of the map
//     * @see HeavySkeletalSwordsman
//     */
//    @Override
//    public SkeletalType createSkeletal() {
//        return new HeavySkeletalSwordsman();
//    }
//
//    /**
//     *
//     * @return the instance of {@link WaterType} enemy on the west side of the map
//     * @see GiantCrab
//     */
//    @Override
//    public WaterType createWaterType() {
//        return new GiantCrab();
//    }
//}
