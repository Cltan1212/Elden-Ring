package game.actions.actorActions.attackActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.resetActions.ResetAction;
import game.runes.RunesManager;
import game.utils.FancyMessage;
import game.utils.Status;

/**
 * An action executed when an actor is killed. Drops all items and weapons carried by the target to the location on the game map where the target was.
 * If the attacker is the player, transfers any runes held by the target to the player. If the player dies, resets the game.
 * If the target has the capability SPECIAL_DEATH, then no items or weapons will be dropped and the target will not be removed from the game map.
 * This action displays a menu description stating that the actor is killed.
 * @author Adrian Kristanto
 * Modified by: Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see Action
 *
 */
public class DeathAction extends Action {
    private Actor attacker;

    /**
     * Constructor.
     *
     * @param actor The {@link Actor} perform death action.
     */
    public DeathAction(Actor actor) {
        this.attacker = actor;
    }

    public DeathAction(){
    }
    /**
     * When the target is killed, the items and weapons carried by target
     * will be dropped to the location in the game map where the target.
     *
     * @param target The {@link Actor} performing the action.
     * @param map The {@link GameMap} the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";

        // if player die
        if (target.hasCapability(Status.HOSTILE_TO_ENEMY)) {

            // reset the game
            Display display = new Display();
            map.draw(display);
            result += "\n" + FancyMessage.YOU_DIED;
            result += new ResetAction().execute(target, map);

            // if other actor die
        } else {
            if (!target.hasCapability(Status.SPECIAL_DEATH) && (map.locationOf(target) != null)){

                ActionList dropActions = new ActionList();

                // drop all items
                for (Item item : target.getItemInventory())
                    dropActions.add(item.getDropAction(target));
                for (WeaponItem weapon : target.getWeaponInventory())
                    dropActions.add(weapon.getDropAction(target));
                for (Action drop : dropActions)
                    drop.execute(target, map);

                if (attacker.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                    // transfer runes to target
                    result += "\n" + target + " drops " + RunesManager.getInstance().transferRunes(target, attacker) + " runes.";
                }

                target.removeCapability(Status.DESPAWNABLE);
                result += System.lineSeparator() + menuDescription(target);
                map.removeActor(target);
            }
        }
//        result += System.lineSeparator() + menuDescription(target);
        return result;
    }

    /**
     * Returns a menu description stating that the actor is killed.
     *
     * @param actor The {@link Actor} performing the action.
     * @return A String describing the menu description of the action
     */
    @Override
    public String menuDescription(Actor actor) {
        String result = "";
        result += actor + " is killed.";
        return result;
    }
}
