package game.grounds.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.enemyFactory.EnemyFactory;
import edu.monash.fit2099.engine.actors.Actor;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

public abstract class SpawnGround extends Ground {
    private final int SPAWN_CHANCE;
    public final EnemyFactory enemyFactory;

    /**
     * Constructor.
     *
     * @param displayChar  character to display for this type of terrain
     * @param spawnChance
     * @param enemyFactory
     */


    public SpawnGround(char displayChar, int spawnChance, EnemyFactory enemyFactory) {
        super(displayChar);
        this.SPAWN_CHANCE = spawnChance;
        this.enemyFactory = enemyFactory;
    }

    @Override
    public void tick(Location location){
        int randomChance = RandomNumberGenerator.getRandomInt(100);
        if (!location.containsAnActor() && (randomChance <= this.SPAWN_CHANCE)){
            location.addActor(this.spawn());
        } else{
            location.setGround(this);
        }

    }

    @Override
    public boolean canActorEnter(Actor actor) {
        // actor can only enter if hostile to enemy or respawnable
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY) || actor.hasCapability(Status.RESPAWNABLE);
    }


    public Actor spawn(){
        return null;
    }

}
