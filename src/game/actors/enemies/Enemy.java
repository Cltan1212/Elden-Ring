package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.AttackAction;
import game.actions.actorActions.DespawnedAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.reset.Resettable;
import game.runes.RuneSource;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

import java.util.HashMap;
import java.util.Map;

public abstract class Enemy extends Actor implements Resettable, RuneSource {

    protected Map<Integer, Behaviour> behaviours = new HashMap<>();
    protected final int DESPAWN_CHANCE = 10;
    public boolean following = false;

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.RESPAWNABLE);
        this.behaviours.put(999, new WanderBehaviour());
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
        else if (randomNum <= DESPAWN_CHANCE && behaviours.get(1).getAction(this, map) != null && !following){
            return new DespawnedAction();
        }

        // add valid behaviour to the list of behaviours
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();

    }

    /**
     * The lone wolf can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // enemy attack player and other enemies
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
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

    public int generateRunes() {
        return 0;
    }

    @Override
    public void reset(GameMap map) {
        map.removeActor(this);
    }
}
