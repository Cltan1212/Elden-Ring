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

        if (!(RandomNumberGenerator.getRandomInt(100) <= 60)) {
            return actor + " misses " + target + ".";
        }

        int damage = weapon.damage();
        String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
        target.hurt(damage);
        if (!target.isConscious()) {
            result += new DeathAction(actor).execute(target, map);
        }

        return result;
    }


    @Override
    public String menuDescription(Actor actor) {
        return actor + " unsheathes " + weapon + " on " + this.target;
    }
}
