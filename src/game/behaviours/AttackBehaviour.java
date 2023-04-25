package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.Status;

import java.util.ArrayList;
import java.util.List;

public class AttackBehaviour implements Behaviour{

    List<String> attackList = new ArrayList<>();
    public AttackBehaviour(){

    }
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        for (Exit exit: here.getExits()){
            // check if an exit contains an actor that is hostile to enemy
            if (exit.getDestination().containsAnActor() && exit.getDestination().getActor().hasCapability(Status.HOSTILE_TO_ENEMY)){
                attackList.add(0, exit.getName());
            }
            else if (exit.getDestination().containsAnActor()){
                attackList.add(exit.getName());
            }
        }

        if (attackList.size() > 1){
            return actor.getWeaponInventory().get(0).getSkill(actor);
        }
        else {
            return actor.getWeaponInventory().get(0).getSkill(actor, attackList.get(0));
        }
    }
}
