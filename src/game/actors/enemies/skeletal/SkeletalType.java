package game.actors.enemies.skeletal;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.PileOfBones;
import game.behaviours.AttackBehaviour;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

/**
 * Abstract class representing a physical SkeletalType enemy in the game world.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see Enemy
 */
public abstract class SkeletalType extends Enemy {

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public SkeletalType(String name, char displayChar, int hitPoints, int spawnChance) {
        super(name, displayChar, hitPoints, spawnChance);
        this.addCapability(Status.HOSTILE_TO_DOG_TYPE_ENEMY);
        this.addCapability(Status.HOSTILE_TO_WATER_TYPE_ENEMY);
        this.addCapability(Status.SPECIAL_DEATH);
    }

    /**
     * Turn into {@link PileOfBones} if this type of enemy is not conscious.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (!this.isConscious()) {
            Location previousLocation = map.locationOf(this);
            map.removeActor(this);
            previousLocation.addActor(new PileOfBones(this));
            return new DoNothingAction();
        }
        return super.playTurn(actions, lastAction, map, display);
    }

    /**
     * The SkeletalType can be attacked by any actor that has the HOSTILE_TO_ENEMY and HOSTILE_TO_SKELETAL_TYPE_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return a list of Actions that allowed otherActor to perform
     * @see AttackBehaviour
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        if (otherActor.hasCapability(Status.HOSTILE_TO_SKELETAL_TYPE_ENEMY)){
            this.behaviours.put(3, new AttackBehaviour(otherActor));
        }
        return super.allowableActions(otherActor, direction, map);
    }

    /**
     * Generate a random amount of runes.
     *
     * @return an integer that represent an amount of runes
     * @see game.runes.RuneSource
     */
    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(35,892);
    }

}
