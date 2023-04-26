package game.actions.actorActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class QuickStepAction extends Action {

    private Actor target;

    private WeaponItem weapon;

    private String direction;

    public QuickStepAction(WeaponItem weapon, Actor target, String direction){
        this.weapon = weapon;
        this.target = target;
        this.direction = direction;

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        int damage = weapon.damage();
        if (this.target != null){
            this.target.hurt(damage);
            result += "\n" + actor + " stabs " + this.target + " for " + damage + " damage";

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

        }else{
            result += "\n" + actor + " misses the attack";
        }
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks (quick step) " + this.target + " and moves away";
    }
}
