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
    public ActionList allowableActions(Actor actor, Location location, String direction){
        return super.allowableActions(actor, location, direction); // call the super class implementation
    }

    @Override
    public boolean canActorEnter(Actor actor){
        return super.canActorEnter(actor);
    }

    @Override
    public void tick(Location location){
        super.tick(location);
    }

    @Override
    public boolean blocksThrownObjects(){
        return super.blocksThrownObjects();
    }

}
