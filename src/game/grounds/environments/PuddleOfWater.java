package game.grounds.environments;

import game.actors.enemies.Enemy;
import game.actors.enemies.enemyFactory.EnemyFactory;

/**
 * PuddleOfWater
 * The PuddleOfWater class is one of the ground in this game that can spawn enemies
 * It extends SpawnGround class
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 */
public class PuddleOfWater extends SpawnGround {


    /**
     * Constructor for PuddleOfWater
     * It sets the displayCharacter and also pass in the enemyLocation
     * @param enemyLocation the type of enemies that will spawn on the ground
     */
    public PuddleOfWater(EnemyFactory enemyLocation) {
        super('~', enemyLocation);
    }

    /**
     * A method to return the enemies spawn at GustOfWind
     * @return new GiantCrab() or new GiantCrayFish() depend on the west or east side of map
     */
    @Override
    public Enemy spawn(){
        return enemyFactory.createWaterType(); // since PuddleOfWater spawn GiantCrab
    }

}
