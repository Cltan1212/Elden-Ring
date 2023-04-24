package game.actions.actorActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.enemies.EnemyType;
import game.actors.enemies.PileOfBones;
import game.behaviours.DropRunesBehaviour;
import game.reset.ResetManager;
import game.utils.FancyMessage;
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

            // special death action for skeletal type enemy
            if (target.hasCapability(EnemyType.SKELETAL)){
                Location currentLocation = map.locationOf(target);
                map.addActor(new PileOfBones(target), currentLocation);
            }

            else {

                ActionList dropActions = new ActionList();

                // drop all items
                for (Item item : target.getItemInventory())
                    dropActions.add(item.getDropAction(target));
                for (WeaponItem weapon : target.getWeaponInventory())
                    dropActions.add(weapon.getDropAction(target));
                for (Action drop : dropActions)
                    drop.execute(target, map);

                // transfer runes to target
                DropRunesBehaviour dropRunesBehaviour = new DropRunesBehaviour(target);
                result += dropRunesBehaviour.getAction(attacker,map).execute(attacker, map);
            }
        }

        // if player die, and the attacker is enemy
        else if (target.hasCapability(Status.HOSTILE_TO_ENEMY)) {

            // only drop runes
            for (Item item: target.getItemInventory())
                if (item.hasCapability(Status.TRADING))
                    item.getDropAction(target);

            // reset the game
            ResetManager.getInstance().run();
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
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY))
            result += FancyMessage.YOU_DIED;
        return result;
    }
}

