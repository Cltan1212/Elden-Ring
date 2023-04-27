package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.actorActions.AttackAction;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttackBehaviour implements Behaviour {

    public AttackBehaviour(){
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {

        Location here = map.locationOf(actor); // get location of current actor
        List<Exit> targetExit = new ArrayList<>();

        // iterate through all actor's exists (8 locations)
        for (Exit exit : here.getExits()) {
            // check if an exit contains an actor that is hostile to enemy
            if (exit.getDestination().containsAnActor() && exit.getDestination().getActor().hasCapability(Status.HOSTILE_TO_ENEMY)) {
                targetExit.add(0, exit);
            } else if (exit.getDestination().containsAnActor()) {
                targetExit.add(exit);
            }
        }

        if (!targetExit.isEmpty()) {
            if (!actor.getWeaponInventory().isEmpty()) { // use their special skill
                if (RandomNumberGenerator.getRandomInt(100) < 50)  // enemy have 50% chance to perform special skill
                    return actor.getWeaponInventory().get(0).getSkill(actor);
                else
                    return new AttackAction(targetExit.get(0).getDestination().getActor(), targetExit.toString());
            } else { // use their intrinsic weapon
                return new AttackAction(targetExit.get(0).getDestination().getActor(), targetExit.toString());
            }
        }
        return null;

    }
}
