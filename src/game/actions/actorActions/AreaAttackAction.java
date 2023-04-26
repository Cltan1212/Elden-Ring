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
     * The list of Actors that will be attacked
     */
//    private List<Actor> target;
    /**
     * The direction of incoming attack.
     */
    private String direction;

    /**
     * Random number generator
     */
//    private Random rand = new Random();

    private Actor target;

    /**
     * Weapon used for the attack
     */
    private Weapon weapon;

    public AreaAttackAction(Actor target, Weapon weapon) {
        this.target = target;
//        this.direction = direction;
        this.weapon = weapon;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = actor + " attacks their surrounding!";

        List<Actor> targets = new ArrayList<Actor>();

        // need to implement -> different actor have different probability of getting attack
        if(!map.contains(actor))
            return null;

        Location actorLocation = map.locationOf(actor);

        for (Exit exit : actorLocation.getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()){
                String returnString = new AttackAction(destination.getActor(), destination.toString(), this.weapon).execute(destination.getActor(), map);
                result += "\n" + returnString;
//                targets.add(destination.getActor());
            }

        }
//        for (Actor targetActor: targets){
//            new AttackAction(targetActor,"", this.weapon);
//        }

        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks anything in the surrounding with " + this.weapon;
    }
}
