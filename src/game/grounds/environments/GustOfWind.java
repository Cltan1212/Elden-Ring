package game.grounds.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.LoneWolf;
import game.utils.Status;

import static game.utils.RandomNumberGenerator.getRandomInt;

public class GustOfWind extends Ground {
    private static final int CHANCE_SPAWN_LONE_WOLF = 33;

    public GustOfWind(){
        super('&');
    }

    @Override
    public void tick(Location location){
        int randomNumber = getRandomInt(100);
        if ((randomNumber <= CHANCE_SPAWN_LONE_WOLF) && (!location.containsAnActor())){
            location.addActor(new LoneWolf());
        }
        else{
            location.setGround(this);
        }
    }

}
