package game.actors.enemies.dog;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.enemies.Enemy;
import game.behaviours.AttackBehaviour;
import game.runes.RunesManager;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

/**
 * Abstract class representing a physical DoyType enemy in the game world.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see Enemy
 *
 */
public abstract class DogType extends Enemy {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     * @param spawnChance the spawning rate
     */
    public DogType(String name, char displayChar, int hitPoints, int spawnChance) {
        super(name, displayChar, hitPoints, spawnChance);
        this.addCapability(Status.HOSTILE_TO_WATER_TYPE_ENEMY);
        this.addCapability(Status.HOSTILE_TO_SKELETAL_TYPE_ENEMY);
    }

    /**
     * The DoyType can be attacked by any {@link Actor} that has the HOSTILE_TO_ENEMY and HOSTILE_TO_DOG_TYPE_ENEMY capability
     *
     * @param otherActor the {@link Actor} that might be performing attack
     * @param direction  String representing the direction of the other {@link Actor}
     * @param map        current {@link GameMap}
     * @return a list of Actions that allowed otherActor to perform
     * @see AttackBehaviour
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        if (otherActor.hasCapability(Status.HOSTILE_TO_DOG_TYPE_ENEMY)){
            this.behaviours.put(3, new AttackBehaviour(otherActor));
        }
        return super.allowableActions(otherActor, direction, map);
    }
}
