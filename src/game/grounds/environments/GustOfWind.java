package game.grounds.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.dog.LoneWolf;
import game.actors.enemies.enemyFactory.EnemyFactory;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

public class GustOfWind extends Ground {
    private static final int SPAWN_CHANCE = 33;
    private final EnemyFactory enemyFactory;
    public GustOfWind(EnemyFactory enemyLocation) {
        super('&');
        this.enemyFactory = enemyLocation;
    }

    @Override
    public void tick(Location location){
        int randomChance = RandomNumberGenerator.getRandomInt(100);
        if (!location.containsAnActor() && (randomChance <= SPAWN_CHANCE)){
            location.addActor(enemyFactory.createDog()); // since Graveyard spawn LoneWolf
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
