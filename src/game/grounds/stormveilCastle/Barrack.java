package game.grounds.stormveilCastle;

import game.actors.enemies.Enemy;
import game.actors.enemies.stormveilCastleEnemy.GodrickSoldier;
import game.grounds.environments.SpawnGround;

public class Barrack extends SpawnGround {

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
