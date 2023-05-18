package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.attackActions.AttackAction;
import game.actions.actorActions.DespawnedAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.reset.ResetManager;
import game.reset.Resettable;
import game.runes.RuneSource;
import game.runes.RunesManager;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

import java.util.HashMap;
import java.util.Map;

/**
 * Abstract base class representing a physical enemy in the game world.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see Actor
 * @see Resettable
 * @see RuneSource
 */

public abstract class Enemy extends Actor implements Resettable, RuneSource {

    /**
     * The {@link Behaviour} that is Enemy can have.
     */
    protected Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * The chance of getting despawn.
     */
    protected final int DESPAWN_CHANCE = 10;

    /**
     * The status to indicate if this enemy is following the player.
     */
    public boolean following = false;

    /**
     * The chance of getting spawn.
     */
    public int spawnChance;

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     * @param spawnChance the spawning rate
     * @see WanderBehaviour
     */
    public Enemy(String name, char displayChar, int hitPoints, int spawnChance) {
        super(name, displayChar, hitPoints);
        RunesManager.getInstance().registerRuneSource(this);
        this.addCapability(Status.RESPAWNABLE);
        this.addCapability(Status.DESPAWNABLE);
        this.addCapability(Status.HOSTILE_TO_ALLIES);
        this.behaviours.put(999, new WanderBehaviour());
        this.spawnChance = spawnChance;
//        this.registerInstance();
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     * @see DespawnedAction
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        int randomNum = RandomNumberGenerator.getRandomInt(100);
        // if not following and randomNum generated is less or equal to DESPAWN_CHANCE

        if (!behaviours.containsKey(1)){
            if (randomNum <= DESPAWN_CHANCE && !following){
                return new DespawnedAction();
            }
        }

        // add valid behaviour to the list of behaviours
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null) {
                System.out.println(behaviours);
                // remove attack behaviour after execution
                this.behaviours.remove(0);
                this.behaviours.remove(3);
                return action;
            }
        }

        return new DoNothingAction();

    }

    /**
     * The enemy can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return a list of Actions that allowed otherActor to perform
     * @see AttackBehaviour
     * @see FollowBehaviour
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // enemy attack player and other enemies
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) || otherActor.hasCapability(Status.HOSTILE_TO_INVADERS)) {
            actions.add(new AttackAction(this, direction));
            following = true;
            this.behaviours.put(0, new AttackBehaviour(otherActor));
            this.behaviours.put(1, new FollowBehaviour(otherActor));

            for (WeaponItem weaponItem: otherActor.getWeaponInventory()){

                // attack action for normal weapon
                actions.add(new AttackAction(this, direction, weaponItem));
                // special skill for area attack
                actions.add(weaponItem.getSkill(otherActor));
                // special skill for target attack
                actions.add(weaponItem.getSkill(this, direction));
            }
        }
        return actions;
    }

    @Override
    public String reset(GameMap map) {
        return "\n" + new DespawnedAction().execute(this, map);
    }
}
