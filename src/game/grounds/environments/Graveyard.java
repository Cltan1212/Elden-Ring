package game.grounds.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.skeletal.HeavySkeletalSwordsman;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

public class Graveyard extends Ground {
    private static final int SPAWN_CHANCE = 27;
    public Graveyard() {
        super('n');
    }

    @Override
    public void tick(Location location){
        int randomChance = RandomNumberGenerator.getRandomInt(100);
        if (!location.containsAnActor() && (randomChance <= SPAWN_CHANCE)){
            location.addActor(new HeavySkeletalSwordsman()); // since Graveyard spawn HeavySkeletalSwordsman
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
