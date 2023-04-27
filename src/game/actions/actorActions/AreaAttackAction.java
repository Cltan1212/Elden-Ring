package game.actions.actorActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.utils.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AreaAttackAction extends Action {

    /**
     * Weapon used for the attack
     */
    private Weapon weapon;

    public AreaAttackAction(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = actor + " attacks their surrounding!";

        Location actorLocation = map.locationOf(actor);

        for (Exit exit : actorLocation.getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()){
                result += "\n" + new AttackAction(destination.getActor(), destination.toString(), this.weapon).execute(actor, map) + "\n";
            }
        }
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks anything in the surrounding with " + this.weapon;
    }
}
