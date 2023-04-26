package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
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
    private final int DESPAWN_CHANCE = 10;

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
//        this.specialAttack = null;
        this.behaviours.put(1, new AttackBehaviour());
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
        // if not following and randomNum generated is less or equal to DESPAWN_CHANCE

        // check 10% chance to despawn NEED TO IMPLEMENT
        if (!behaviours.containsKey(1)) {
            if (randomNum <= DESPAWN_CHANCE) {
                return new DespawnedAction();
            }
        } else if (randomNum <= DESPAWN_CHANCE && behaviours.get(2).getAction(this, map) != null) {
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
     * Returns a new collection of the Actions that the otherActor can do to the current Actor.
     * The lone wolf can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {

        //  only either area and attack, behaviour only enemy


        ActionList actions = new ActionList();


        // SMTG LIKE if (otherActor.hasCapability(Status.HOSTILE.ENEMY) && this.hasCapability(Status.FOLLOWING){
        //                  this.behaviour.put(2, followBehaviour(this));
        //  else{

        // if isCaucious
        // if not on the same ground???

        // have a variable STATUS.SPECIAL_SKILL
        // if other.getWeaponInventory() >0{
        //

        // check if is concious
        // capability if player or following, add behaviour following
        // if not the same location, loop through getinventory, Action.weaponSkill otherActor.getSkill
        // if weapon skill is not empty, then add actions,  And actions.add(new attackAction

        // else if have special skill, get random int, (2)
        // if skillchance == 0
        // Then area attack acion with intrinsic
        // then add
        //


        // TODO: check otherActor is not the same type as actor
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {

            // HINT 1: The AttackAction above allows you to attack the enemy with your intrinsic weapon.
            // HINT 1: How would you attack the enemy with a weapon?

            actions.add(new AttackAction(this, direction)); // using intrinsic weapon

            this.behaviours.put(1, new FollowBehaviour(otherActor));

            for (WeaponItem weapon : otherActor.getWeaponInventory()) { // attack with weapon

                // ONLY DISPLAY AREA ATTACK OPTION WHEN THERE ARE MORE THAN ONE ENEMY AROUND

                // skill for area attack
                actions.add(weapon.getSkill(this));

                // skill for target attack
                actions.add(weapon.getSkill(this, direction));

            }
        } else if (otherActor.hasCapability(Status.RESPAWNABLE)){
//            this.behaviours.put(4, new FollowBehaviour(otherActor));
            this.behaviours.put(3, new AttackBehaviour(otherActor));
        }
        return actions;
    }
}


//        this.getWeaponInventory().get(0).getSkill(this);
//        this.getWeaponInventory().get(0).getSkill(this);

//        Actor otherActor;
//        for (Exit exit: map.locationOf(this).getExits()){
//            Location destination = exit.getDestination();
//            if (destination.containsAnActor()){
//                otherActor = map.getActorAt(destination);
//                if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
//                    this.behaviours.put(0, new AttackBehaviour(otherActor));
//                }
//            }
//        }


