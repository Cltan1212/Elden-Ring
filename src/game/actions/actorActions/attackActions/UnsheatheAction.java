package game.actions.actorActions.attackActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.RandomNumberGenerator;
import game.weapons.combat.Uchigatana;

/**
 * Special Action class that allows an actor to unsheathe a WeaponItem on an enemy Actor.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see Action
 * @see Uchigatana
 */
public class UnsheatheAction extends Action {

    private Actor target;

    private WeaponItem weapon;

    /**
     * Constructor.
     *
     * @param weapon The {@link WeaponItem} to use in the attack
     * @param target The target {@link Actor} to attack
     */
    public UnsheatheAction(WeaponItem weapon, Actor target){
        this.weapon = weapon;
        this.target = target;

    }

    /**
     * Method that executes the UnsheatheAction, allowing the {@link Actor} to attack the target {@link Actor}.
     *
     * @param actor The {@link Actor} performing the action.
     * @param map The {@link GameMap} the {@link Actor} is on.
     * @return A string describing the result of the action
     */
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

    /**
     * Method that returns a string description of the action for display in the menu.
     *
     * @param actor The {@link Actor} performing the action.
     * @return A string describing the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " unsheathes " + weapon + " on " + this.target;
    }
}
