package game.grounds.environments;

import game.actors.enemies.Enemy;
import game.actors.enemies.enemyFactory.EnemyFactory;

/**
 * ThunderStorm
 * The ThunderStorm class is one of the ground in this game that can spawn enemies
 * It extends SpawnGround class
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 * @see SpawnGround
 */
public class ThunderStorm extends SpawnGround{

    /**
     * Constructor for ThunderStorm
     * It sets the displayCharacter and also pass in the enemyLocation
     * @param enemyLocation the type of enemies that will spawn on the ground
     * @see EnemyFactory
     */
    public ThunderStorm(EnemyFactory enemyLocation) {
        super('%', enemyLocation);
    }

    /**
     * This method returns enemies that will spawn on the ground
     * @return new FlyingType Enemy
     */
    @Override
    public Enemy spawn(){
        return enemyFactory.createFlyingType();}
}
