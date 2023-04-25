package game.actions.actorActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.RandomNumberGenerator;

public class UnsheatheAction extends Action {

    private Actor target;

    private WeaponItem weapon;

    public UnsheatheAction(WeaponItem weapon, Actor target){
        this.weapon = weapon;
        this.target = target;
    }

    // 60% chance to hit the enemy
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = actor + " unsheathes their " + weapon + " and strikes!";
        if (RandomNumberGenerator.getRandomInt(100) < 60){
            int damage = 2 * weapon.damage();
            actor.hurt(damage);
            result += "\n" + actor + " deals " + damage + " damage.";

        } else{
            result += "\n" + actor + " misses their attack!";
        }
        return result;
    }


    @Override
    public String menuDescription(Actor actor) {
        return actor + " unsheathes " + weapon + " on " + target;
    }
}
