package game.grounds.environments;

import game.actors.enemies.Enemy;
import game.actors.enemies.enemyFactory.EnemyFactory;


/**
 * GustOfWind
 * The GustOfWind class is one of the ground in this game that can spawn enemies
 * It extends SpawnGround class
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 * @see SpawnGround
 */
public class GustOfWind extends SpawnGround {

    /**
     * This is the constructor for GustOfWind
     * It sets the displayCharacter and also pass in the enemyLocation
     * @param enemyLocation the type of enemies that will spawn on the ground
     * @see EnemyFactory
     */
    public GustOfWind(EnemyFactory enemyLocation) {
        super('&', enemyLocation);
    }

    /**
     * A method to return the enemies spawn at GustOfWind
     * @return new LoneWolf() or new GiantDog() depend on the west or east side of map
     */
    @Override
    public Enemy spawn(){
        return enemyFactory.createDog(); // since GustOfWind spawn LoneWolf
    }

}
