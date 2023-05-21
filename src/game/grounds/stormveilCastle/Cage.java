package game.grounds.stormveilCastle;

import game.actors.enemies.Enemy;
import game.actors.enemies.stormveilCastleEnemy.Dog;
import game.grounds.environments.SpawnGround;

/**
 * Cage
 * The Cage class is one of the ground in this game that can spawn enemies
 * It extends SpawnGround class
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 * @see SpawnGround
 */
public class Cage extends SpawnGround {
    /**
     * Constructor.
     *
     */
    public Cage() {
        super('<');
    }

    /**
     * This method returns enemies that will spawn on the ground
     * @return the enemies to be spawn based on each ground
     */
    public Enemy spawn(){
        return new Dog();
    }

}
