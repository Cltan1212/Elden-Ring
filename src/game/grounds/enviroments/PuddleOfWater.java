package game.grounds.enviroments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.waterTypeEnemy.GiantCrab;
import game.utils.Status;

import static game.utils.RandomNumberGenerator.getRandomInt;

public class PuddleOfWater extends Ground {
    private static final int CHANCE_SPAWN_GIANT_CRAB = 2;

    public PuddleOfWater(){
        super('~');
    }

    @Override
    public void tick(Location location){
        int randomNumber = getRandomInt(100);
        if ((randomNumber <= CHANCE_SPAWN_GIANT_CRAB) && (!location.containsAnActor())){
            location.addActor(new GiantCrab());
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
