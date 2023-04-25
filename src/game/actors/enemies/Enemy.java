package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.AttackAction;
import game.actions.actorActions.DeathAction;
import game.behaviours.*;
import game.runes.RuneSource;
import game.runes.Runes;
import game.runes.RunesManager;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

import java.util.HashMap;
import java.util.Map;

public abstract class Enemy extends Actor implements RuneSource {

    private Map<Integer, Behaviour> behaviours = new HashMap<>();
    Actor attacker;

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
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

//        for (Exit exits : map.locationOf(this).getExits()) {
//            Location location = exits.getDestination();
//
//            // if there is any actor surrounding
//            if (location.containsAnActor()) {
//                Actor otherActor = location.getActor();
//
//                // behaviour when encounter a player
//                if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
//
//                    // enemy attack player when is being attacked -> how??
//                    // what is the use of allowable action or last action?
//                    // last actions?
//                    if (attacked){
//                        this.behaviours.put(5, new AttackBehaviour(otherActor));
//                    }
//
//                    // follow the player
//                    else{
//                        this.behaviours.put(10, new FollowBehaviour(otherActor));
//                    }
//
//                }
//
//                // suppose an enemy of one type is close to another type of enemy
//                // in that case, they will attack without following them
//                if (otherActor.hasCapability(Status.HOSTILE_TO_DOG_TYPE_ENEMY)) {
//                    this.behaviours.put(5, new AttackBehaviour(otherActor));
//                }
//            }
//        }

        if (!this.isConscious()){
            // if attacker is player -> transfer to the player (how should I do this?)
            // then remove this from map
           map.removeActor(this);

        }

        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
            for (WeaponItem weaponItem: otherActor.getWeaponInventory()){

                // skill for area attack
                actions.add(weaponItem.getSkill(otherActor));

                // skill for target attack
                actions.add(weaponItem.getSkill(otherActor, direction));
            }
        }

        return actions;
    }


    public int generateRunes() {
        return 0;
    }
}
