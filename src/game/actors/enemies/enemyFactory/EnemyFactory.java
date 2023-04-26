package game.actors.enemies.enemyFactory;

import game.actors.enemies.dog.Dog;
import game.actors.enemies.skeletal.Undead;
import game.actors.enemies.water.Crustracean;

public interface EnemyFactory {
    public Dog createDog();
    public Undead createUndead();
    public Crustracean createCrustracean();
}
