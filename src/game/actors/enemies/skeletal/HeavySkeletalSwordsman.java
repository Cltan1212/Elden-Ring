package game.actors.enemies.skeletal;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.actorActions.AttackAction;
import game.actors.enemies.Enemy;
import game.behaviours.Behaviour;
import game.utils.Status;
import game.weapons.Grossmesser;

import java.util.HashMap;
import java.util.Map;

public class HeavySkeletalSwordsman extends Skeletal {


    private Map<Integer, Behaviour> behaviours = new HashMap<>();
    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman", 'q', 153);
        this.addWeaponToInventory(new Grossmesser());
//        this.addCapability(Status.SPINNING_ATTACK);
//        this.setSpecialAttack("Spinning Attack");  // might not needed


    }

//    @Override
//    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
//        for (Behaviour behaviour : behaviours.values()) {
//            Action action = behaviour.getAction(this, map);
//            if(action != null)
//                return action;
//        }
//        return new DoNothingAction();
//    }
//
//    /**
//     * The lone wolf can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
//     *
//     * @param otherActor the Actor that might be performing attack
//     * @param direction  String representing the direction of the other Actor
//     * @param map        current GameMap
//     * @return
//     */
//    @Override
//    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
//        ActionList actions = new ActionList();
//        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
//            actions.add(new AttackAction(this, direction));
//            // HINT 1: The AttackAction above allows you to attak the enemy with your intrinsic weapon.
//            // HINT 1: How would you attack the enemy with a weapon?
//        }
//        return actions;
//    }
//
//
    @Override
    public void reset() {

    }
}
