package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import game.actions.actorActions.AreaAttackAction;
import game.actions.actorActions.AttackAction;
import game.utils.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * A class that automatically calls AttackAction on the actor's surroundings if there is another actor
 */
public class AttackBehaviour implements Behaviour {

//    private Map<Actor, String> nearbyEnemies = new HashMap<>();  // store the actor nearby and its direction

    List<String> attackList = new ArrayList<>();

    // Purpose of this class: Enemies attack player???
//    private final Actor targetAttack;

//    public AttackBehaviour(Actor targetAttack) {
//        this.targetAttack = targetAttack;
//    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        // this method should return a target Action for the actor to attack



        // LOOP THROUGH ALL LOCATION, ADD Actor opponent = destination.getActor()
        // THEN CALL ATTACKAREAATTACK, ATTACKACTION -> (GET SKILL, INTRINSIC WEAPON)
        // IF GETINVENTORY > 0 smtg

        Location here = map.locationOf(actor); // get location of current actor

        // iterate through all actor's exists (8 locations)
        for (Exit exit : here.getExits()) {
            // check if an exit contains an actor that is hostile to enemy
            if (exit.getDestination().containsAnActor() && exit.getDestination().getActor().hasCapability(Status.HOSTILE_TO_ENEMY)) {
                String direction = exit.getName();
                attackList.add(0, direction);
            } else if (exit.getDestination().containsAnActor()) {
                attackList.add(exit.getName());
            }
        }

        if (attackList.size() > 1 && actor.getWeaponInventory().size()!= 0) {  // more than one actor -> AreaAttackAction
            return actor.getWeaponInventory().get(0).getSkill(actor);
        } else if (attackList.size() == 1 && actor.getWeaponInventory().size() != 0) {
            if (actor.getWeaponInventory().size() != 0){
                return actor.getWeaponInventory().get(0).getSkill(actor, attackList.get(0));
            }
        }
        return null;
    }
}



// check if target and actor are present in map
// if either not present, return null -> no action performed
// else iterates over the location near, and check if there is any actor
// having capability Status.HOSTILE_TO_ENEMY
// if contains, then create an attack else null -> no action performed
// return new xxAction();
// else
// LOOK for enemies around actor
// if more then one enemy -> AreaAttackAction (constructor of AreaAttackAction take in list of enemies to attack)
// which loop through the list and attack each of them
// if only one enemy -> AttackAction

// maybe can have a specialAttack in giantCrab and heavyskeletal, so if != null, can perform AreaAttackAction

//                nearbyEnemies.add(exit.getDestination().getActor());

    // originally given code
//                return new AttackAction(exit.getDestination().getActor(), direction); // current actor calls AttackAction on the other actor



        // how to check if actor is enemy?
//        if (!nearbyEnemies.isEmpty() && (actor.hasCapability(Status.SLAMMING_ATTACK) || actor.hasCapability(Status.SPINNING_ATTACK))){
//            Actor targetOn = nearbyEnemies.get(0);
//            if (nearbyEnemies.size() <= 1){
//                return new AttackAction(targetOn, "at", actor.getWeaponInventory().get(0));  // how to retrieve the weapon
//            } else{
//                return new AreaAttackAction(nearbyEnemies, "at", actor.getWeaponInventory().get(0));
//            }
//        } else if (!nearbyEnemies.isEmpty()){
//            Actor targetOn = nearbyEnemies.get(0);
//            return new AttackAction(targetOn, "at", actor.getWeaponInventory().get(0));
//
//        }
//
//        return null; // if no action is called

//    }

