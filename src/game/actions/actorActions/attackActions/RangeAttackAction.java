package game.actions.actorActions.attackActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.actorActions.attackActions.AttackAction;

public class RangeAttackAction extends Action {
    private final int maxRange;
    private final Weapon weapon;
    private final Actor target;

    public RangeAttackAction(int maxRange, Weapon weapon, Actor subject) {
        this.maxRange = maxRange;
        this.weapon = weapon;
        this.target = subject;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        Location here = map.locationOf(actor);
        Location there = map.locationOf(target);

        int distance = distance(here, there);
        if (distance == 2 && distance <= maxRange){
            result += new AttackAction(target, there.toString(),weapon).execute(actor, map);
        }
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return target.toString();
    }

    private int distance(Location a, Location b){
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}
