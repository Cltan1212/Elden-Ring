package game.grounds.enviroments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.enemySpawn.EnemyLocation;
import game.utils.Status;

import static game.utils.RandomNumberGenerator.getRandomInt;

public class Graveyard extends Ground {
    private static final int CHANCE_SPAWN_SKELETAL = 27;
    private final EnemyLocation enemyLocation;

    public Graveyard(EnemyLocation enemyLocation) {
        super('n');
        this.enemyLocation = enemyLocation;
    }

    @Override
    public void tick(Location location){
        int randomNumber = getRandomInt(100);
        if ((randomNumber <= CHANCE_SPAWN_SKELETAL) && (!location.containsAnActor())){
            location.addActor(enemyLocation.createDog());
        }
        else{
            location.setGround(this);
        }
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.RESPAWNABLE) || actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }
}
