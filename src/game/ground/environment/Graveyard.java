package game.ground.environment;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class Graveyard extends Ground {
    private int spawnChance = 27;

    public Graveyard() {
        super('n');
    }



    @Override
    public void tick(Location location){
        super.tick(location);
    }



}
