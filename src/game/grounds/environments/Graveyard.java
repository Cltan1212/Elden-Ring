package game.grounds.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.HeavySkeletalSwordsman;

import static game.utils.RandomNumberGenerator.getRandomInt;

public class Graveyard extends Ground {
    private static final int CHANCE_SPAWN_SKELETAL = 27;

    public Graveyard(){
        super('n');
    }

    @Override
    public void tick(Location location){
        int randomNumber = getRandomInt(100);
        if ((randomNumber <= CHANCE_SPAWN_SKELETAL) && (!location.containsAnActor())){
            location.addActor(new HeavySkeletalSwordsman());
        }
        else{
            location.setGround(this);
        }
    }
}
