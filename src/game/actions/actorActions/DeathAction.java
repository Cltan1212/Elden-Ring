package game.actions.actorActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.runes.RunesManager;
import game.utils.Status;

/**
 * An action executed if an actor is killed.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class DeathAction extends Action {
    private Actor attacker;

    public DeathAction(Actor actor) {
        this.attacker = actor;
    }

    /**
     * When the target is killed, the items & weapons carried by target
     * will be dropped to the location in the game map where the target was
     *
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";

        // if the attacker is player
        if (attacker.hasCapability(Status.HOSTILE_TO_ENEMY)) {

            if (!target.hasCapability(Status.SPECIAL_DEATH)){

                ActionList dropActions = new ActionList();

                // drop all items
                for (Item item : target.getItemInventory())
                    dropActions.add(item.getDropAction(target));
                for (WeaponItem weapon : target.getWeaponInventory())
                    dropActions.add(weapon.getDropAction(target));
                for (Action drop : dropActions)
                    drop.execute(target, map);

                // transfer runes to target
                result += "\n" +target + " drops " + RunesManager.getInstance().transferRunes(target, attacker) + " runes.";
            }
        }

        // if player die, and the attacker is enemy
        else if (target.hasCapability(Status.HOSTILE_TO_ENEMY)) {

            // reset the game
//            result += new ResetAction();
        }

        // remove actor
        map.removeActor(target);
        result += System.lineSeparator() + menuDescription(target);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        String result = "";
        result += actor + " is killed.";
        return result;
    }
}
