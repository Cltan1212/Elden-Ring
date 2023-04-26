package game.grounds.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.enemyFactory.EnemyFactory;
import game.utils.RandomNumberGenerator;

public class Graveyard extends SpawnGround {

    public Graveyard(EnemyFactory enemyLocation) {
        super('n', 27, enemyLocation);
    }

    @Override
    public Actor spawn(){
        return enemyFactory.createUndead(); // since Graveyard spone HeavySkeletalSwordsman
    }

}
