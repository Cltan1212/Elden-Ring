package game.actors.allyInvader;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import game.actions.actorActions.DespawnedAction;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.combat.*;
import game.reset.ResetManager;
import game.reset.Resettable;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * AllyOrInvaderType
 * An abstract class representing an ally or invader actor in the game
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 * @see Actor
 */
public abstract class AllyOrInvaderType extends Actor implements Resettable {

    /**
     * The {@link Behaviour} that is Enemy can have.
     */
    protected Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * The {@link CombatArchetypes} role that this actor will have
     */
    public CombatArchetypes role;

    /**
     * An ArrayList for storing all the roles available in this game
     */
    public ArrayList<CombatArchetypes> allRoles = new ArrayList<>();

    /**
     * Constructor.
     * When spawned/summoned into the world, an Ally/Invader can start with any of the available roles (chosen randomly).
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public AllyOrInvaderType(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        allRoles.add(new Samurai());
        allRoles.add(new Wretch());
        allRoles.add(new Bandit());
        allRoles.add(new Astrologer());
        int randomChance = RandomNumberGenerator.getRandomInt(0, 3);
        this.behaviours.put(999, new WanderBehaviour());
        role = allRoles.get(randomChance);

        resetMaxHp(role.getStartingHitPoint());
        this.addWeaponToInventory(role.getStartingWeapon());

        // for reset actions
        this.registerInstance();
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     * @see DoNothingAction
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // add valid behaviour to the list of behaviours
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null) {
                // remove attack behaviour after execution
                this.behaviours.remove(0);
                this.behaviours.remove(3);
                return action;
            }
        }
        return new DoNothingAction();
    }

    /**
     * This method is used for resetting purpose
     * @param map the {@link GameMap} to reset the object on.
     * @return A String showing that the actor have been reset (removed from the map)
     */
    @Override
    public String reset(GameMap map) {
        if (!ResetManager.getInstance().getPlayer().hasCapability(Status.RESTING)){
            return "\n" + new DespawnedAction().execute(this, map);
        }
        else{
            ResetManager.getInstance().updateResettable(this);
        }
        return "";
    }
}
