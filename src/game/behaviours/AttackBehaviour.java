package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.Status;

import java.util.ArrayList;
import java.util.List;

public class AttackBehaviour implements Behaviour {

    private final Actor targetAttack;
    public AttackBehaviour(Actor targetAttack){
        this.targetAttack = targetAttack;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {

        Location here = map.locationOf(actor); // get location of current actor
        List<String> attackList = new ArrayList<>();

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
