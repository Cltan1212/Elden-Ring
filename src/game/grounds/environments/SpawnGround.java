package game.grounds.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.dog.LoneWolf;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

public abstract class SpawnGround extends Ground {

    private final int SPAWN_CHANCE;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     * @param spawnChance
     */


    public SpawnGround(char displayChar, int spawnChance) {
        super(displayChar);
        SPAWN_CHANCE = spawnChance;
    }

    @Override
    public void tick(Location location){
        int randomChance = RandomNumberGenerator.getRandomInt(100);
        if (!location.containsAnActor() && (randomChance <= SPAWN_CHANCE)){
            location.addActor(new LoneWolf()); // since Graveyard spawn LoneWolf
        } else{
            location.setGround(this);
        }
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        // actor can only enter if hostile to enemy or respawnable
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY) || actor.hasCapability(Status.RESPAWNABLE);
    }
}
