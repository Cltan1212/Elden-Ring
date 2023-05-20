package game.actors.allyInvader;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
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

public abstract class AllyOrInvaderType extends Actor implements Resettable {

    protected Map<Integer, Behaviour> behaviours = new HashMap<>();

    public CombatArchetypes role;
    ArrayList<CombatArchetypes> allRoles = new ArrayList<>();

    /**
     * Constructor.
     * When spawned/summoned into the world, an Ally can start with any of the available roles (chosen randomly).
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
