package game.grounds.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.enemyFactory.EnemyFactory;
import game.utils.RandomNumberGenerator;

public class GustOfWind extends SpawnGround {
    public GustOfWind(EnemyFactory enemyLocation) {
        super('&', 33, enemyLocation);
    }

    @Override
    public Enemy spawn(){
        return enemyFactory.createDog(); // since GustOfWind spawn LoneWolf
    }

}
