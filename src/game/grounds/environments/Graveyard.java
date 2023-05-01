package game.grounds.environments;

import game.actors.enemies.Enemy;
import game.actors.enemies.enemyFactory.EnemyFactory;

/**
 * Graveyard
 * The Graveyard class is one of the ground in this game that can spawn enemies
 * It extends SpawnGround class
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 */
public class Graveyard extends SpawnGround {

    /**
     * This is the constructor for Graveyard
     * It sets the displayCharacter and also pass in the enemyLocation
     * @param enemyLocation the type of enemies that will spawn on the ground
     */
    public Graveyard(EnemyFactory enemyLocation) {
        super('n', enemyLocation);
    }

    /**
     * A method to return the enemies spawn at Graveyard
     * @return new HeavySkeletalSwordsman() or new SkeletalBandit() depend on the west or east side of map
     */
    @Override
    public Enemy spawn(){
        return enemyFactory.createSkeletal(); // since Graveyard spawn HeavySkeletalSwordsman
    }

}
