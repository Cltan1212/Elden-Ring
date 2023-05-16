package game.actions.actorActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.reset.ResetManager;
import game.runes.Runes;
import game.utils.FancyMessage;
import game.utils.Status;

/**
 * An action that is executed when the game is reset.
 * It resets the game by calling ResetManager.getInstance().run(), and moves the actor to the last visited location,
 * adding a Rune to the location where the actor died if the actor is not in a resting state.
 * This action is called when the player dies, or when the game is reset for other reasons.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see ResetManager
 * @see Runes
 */
public class ResetAction extends Action {

    /**
     * Default constructor for the ResetAction.
     */
    public ResetAction(){
    }

    /**
     * Executes the action, moving the actor to the last visited location, and adding a Rune to the location where the actor died if the actor is not in a resting state.
     *
     * @param actor The {@link Actor} performing the action.
     * @param map The {@link GameMap} the actor is on.
     * @return A message that describes the result of the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Location lastSite = map.at(ResetManager.getInstance().getLastVisited().locationX, ResetManager.getInstance().getLastVisited().locationY);
        String result = "";
        result += ResetManager.getInstance().run();
        if(!actor.hasCapability(Status.RESTING)){
            Location previousLocation = ResetManager.getInstance().getPlayer(actor).lastLocation;
            System.out.println(previousLocation);
            Runes runes = new Runes(actor, previousLocation);
            previousLocation.addItem(runes);
            map.moveActor(actor, lastSite);

        }

        return result;
    }

    /**
     * Returns the description of the action to be displayed on the menu.
     *
     * @param actor The {@link Actor} performing the action.
     * @return A string that describes the menu option for this action.
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
