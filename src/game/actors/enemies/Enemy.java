package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.actorActions.AreaAttackAction;
import game.actions.actorActions.AttackAction;
import game.actions.actorActions.DespawnedAction;
import game.actors.Player;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.reset.Resettable;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

import java.util.HashMap;
import java.util.Map;


public abstract class Enemy extends Actor implements Resettable {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();
    private final int despawnChance = 10;

    // this will give the reference to the same player object created in application.java
    // Singleton pattern, null, '\n', 0, those value are ignored when retrieving the singleton instance
//    Player player = Player.getInstance(null, '\0', 0);

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
//        this.behaviours(1, new AttackBehaviour())
//        this.behaviours.put(2, new FollowBehaviour(player));
        this.behaviours.put(999, new WanderBehaviour());
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
        if (randomNum <= despawnChance && behaviours.get(2).getAction(this, map) != null){  // if not following and <= despawnChance, can call DespawnedAction()
            return new DespawnedAction();
        }
        // add valid behaviour to the list of behaviours
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
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
        // TODO: check otherActor is not the same type as actor
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
            // HINT 1: The AttackAction above allows you to attak the enemy with your intrinsic weapon.
            // HINT 1: How would you attack the enemy with a weapon?
            for (Weapon weapon: otherActor.getWeaponInventory()){
                actions.add(new AttackAction(this, direction, weapon));

            }
        } else if (otherActor.hasCapability(Status.SPINNING_ATTACK)){
//            to add: AreaAttackAction if have SPINNING_ATTACK
//            actions.add(new AreaAttackAction());
        }
        return actions;
    }
}

