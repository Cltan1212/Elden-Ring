package game.actors.enemies.enemyFactory;

import game.actors.enemies.dog.Dog;
import game.actors.enemies.dog.GiantDog;
import game.actors.enemies.skeletal.SkeletalBandit;
import game.actors.enemies.skeletal.Undead;
import game.actors.enemies.water.Crustracean;
import game.actors.enemies.water.GiantCrayFish;

public class EastMapFactoryEnemy implements EnemyFactory{
    @Override
    public Dog createDog() {
        return new GiantDog();
    }

    @Override
    public Undead createUndead() {
        return new SkeletalBandit();
    }

    @Override
    public Crustracean createCrustracean() {
        return new GiantCrayFish();
    }

}
