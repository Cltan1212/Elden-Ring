package game.grounds.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.enemyFactory.EnemyFactory;
import edu.monash.fit2099.engine.actors.Actor;
import game.utils.RandomNumberGenerator;
import game.utils.Status;


/**
 * The abstract class to allows Ground that are able to spawn enemies to extends from it
 * Created by:
 * @author MY_LAB7_Group 6
 * @version 3
 */
public abstract class SpawnGround extends Ground {

    /**
     *
     */
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
        this.enemyFactory = enemyFactory;
    }

    @Override
    public void tick(Location location){
        int randomChance = RandomNumberGenerator.getRandomInt(100);
        if (!location.containsAnActor() && (randomChance <= this.spawn().spawnChance)){
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


    public Enemy spawn(){
        return null;
    }

}
