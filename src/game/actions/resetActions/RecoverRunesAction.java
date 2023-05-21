package game.actions.resetActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.runes.Runes;
import game.runes.RunesManager;

/**
 * A class that represents an action of recovering runes from a {@link Runes} object
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see Action
 */
public class RecoverRunesAction extends Action {

    private final Runes runes;

    /**
     * Constructor.
     *
     * @param runes a {@link Runes} object that the runes will be recovered from
     */
    public RecoverRunesAction(Runes runes){
        this.runes = runes;
    }
    @Override
    public String execute(Actor actor, GameMap map) {

        if (actor == runes.getRunesHolder())
            RunesManager.getInstance().addRunes(actor, runes.generateRunes());
        RunesManager.getInstance().removeRuneSource(runes);
        map.locationOf(actor).removeItem(runes);

        return actor + " retrieves Runes (value: " + runes.generateRunes() + ")";
    }

    /**
     * Returns a description of the action that can be displayed in the menu.
     *
     * @param actor The {@link Actor} performing the action.
     * @return a message describing the result of the action.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " recovered runes";
    }
}
