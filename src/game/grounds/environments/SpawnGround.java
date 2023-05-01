package game.grounds.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.enemyFactory.EnemyFactory;
import edu.monash.fit2099.engine.actors.Actor;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

/**
 * SpawnGround
 * An abstract class acting as the parent class of ground that can spawn enemies.
 * It inherits Ground
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 * @see Ground
 */
public abstract class SpawnGround extends Ground {
    public final EnemyFactory enemyFactory;

    /**
     * Constructor
     * @param displayChar  character to display
     * @param enemyFactory the type of enemies that will spawn on the ground
     */
    public SpawnGround(char displayChar, EnemyFactory enemyFactory) {
        super(displayChar);
        this.enemyFactory = enemyFactory;
    }

    /**
     * Ground can also experience the joy of time.
     * It will spawn enemies if the random spawn chance generated is less than or equal to the spawn chance of each enemy.
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location){
        int randomChance = RandomNumberGenerator.getRandomInt(100);
        if (!location.containsAnActor() && (randomChance <= this.spawn().spawnChance)){
            location.addActor(this.spawn());
        } else{
            location.setGround(this);
        }
    }

    /**
     * This method serve to check if an actor can enter the ground
     * @param actor the Actor to check
     * @return boolean, true if it can enter, false otherwise
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        // actor can only enter if hostile to enemy or respawnable
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY) || actor.hasCapability(Status.RESPAWNABLE);
    }

    /**
     * This method returns enemies that will spawn on the ground
     * @return the enemies to be spawn based on each ground
     */
    public Enemy spawn(){
        return null;
    }
}
