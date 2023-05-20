package game.grounds.stormveilCastle;

import game.actors.enemies.Enemy;
import game.actors.enemies.stormveilCastleEnemy.GodrickSoldier;
import game.grounds.environments.SpawnGround;

/**
 * Barrack
 * The Barrack class is one of the ground in this game that can spawn enemies
 * It extends SpawnGround class
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 * @see SpawnGround
 */
public class Barrack extends SpawnGround {

    /**
     * Constructor.
     */
    public Barrack() {
        super('B');
    }

    /**
     * This method returns enemies that will spawn on the ground
     * @return the enemies to be spawn based on each ground
     */
    public Enemy spawn(){
        return new GodrickSoldier();
    }
}
