package game.actions.actorActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class QuickStepAction extends Action {

    private Actor target;

    private Weapon weapon;
    private String direction;
    public QuickStepAction(Actor target, String direction, Weapon weapon){
        this.direction = direction;
        this.weapon = weapon;
        this.target = target;

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";

        result += new AttackAction(target, direction, weapon).execute(actor, map);

        // use move away from enemy, evading their attack, randomly pick a random location
        List<Location> emptyLocations = new ArrayList<Location>();
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor) && !destination.containsAnActor()) {
                emptyLocations.add(destination);
            }
        }
        if (!emptyLocations.isEmpty()){
            Location newLocation = emptyLocations.get(RandomNumberGenerator.getRandomInt(emptyLocations.size()));
            map.moveActor(actor, newLocation);
            result += "\n" + actor + " moves to (" + newLocation.x() + ", " + newLocation.y() + ")";
        }
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks (quick step) " + this.target + " and moves away";
    }
}
