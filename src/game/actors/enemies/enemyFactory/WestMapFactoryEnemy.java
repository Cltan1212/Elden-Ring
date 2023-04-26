package game.actors.enemies.enemyFactory;

import game.actors.enemies.dog.Dog;
import game.actors.enemies.dog.LoneWolf;
import game.actors.enemies.skeletal.HeavySkeletalSwordsman;
import game.actors.enemies.skeletal.Undead;
import game.actors.enemies.water.Crustracean;
import game.actors.enemies.water.GiantCrab;

public class WestMapFactoryEnemy implements EnemyFactory{
    @Override
    public Dog createDog() {
        return new LoneWolf();
    }

    @Override
    public Undead createUndead() {
        return new HeavySkeletalSwordsman();
    }

    @Override
    public Crustracean createCrustracean() {
        return new GiantCrab();
    }
}
