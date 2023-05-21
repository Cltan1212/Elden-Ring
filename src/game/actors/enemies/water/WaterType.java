package game.actors.enemies.water;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.enemies.Enemy;
import game.behaviours.AttackBehaviour;
import game.behaviours.WanderBehaviour;
import game.utils.Status;

/**
 * Abstract class representing a physical WaterType enemy in the game world.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see Enemy
 */
public abstract class WaterType extends Enemy {

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     * @param spawnChance the spawning rate
     * @see WanderBehaviour
     */
    public WaterType(String name, char displayChar, int hitPoints, int spawnChance) {
        super(name, displayChar, hitPoints, spawnChance);
        this.addCapability(Status.HOSTILE_TO_DOG_TYPE_ENEMY);
        this.addCapability(Status.HOSTILE_TO_SKELETAL_TYPE_ENEMY);
        this.addCapability(Status.HOSTILE_TO_STORMVEIL_CASTLE_ENEMY);
        this.addCapability(Status.HOSTILE_TO_FLYING_TYPE_ENEMY);
    }

    /**
     * The enemy can be attacked by any actor that has the HOSTILE_WATER_TYPE_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return a list of Actions that allowed otherActor to perform
     * @see AttackBehaviour
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        if (otherActor.hasCapability(Status.HOSTILE_TO_WATER_TYPE_ENEMY)){
            this.behaviours.put(3, new AttackBehaviour(otherActor));
        }
        return super.allowableActions(otherActor, direction, map);
    }
}
