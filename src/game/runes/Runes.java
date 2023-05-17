package game.runes;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.*;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.resetActions.RecoverRunesAction;
import game.reset.Resettable;
import game.utils.Status;

/**
 * Class representing items that can be used as Runes in the game world
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see Item
 * @see RuneSource
 * @see Resettable
 */

public class Runes extends Item implements RuneSource, Resettable{

    private final int runesAmount;
    private final Actor runesHolder;
    private final Location location;

    /** Constructor
     *
     * @param runesHolder the {@link Actor} who drops this item
     * @param location the {@link Location} this item present
     */
    public Runes(Actor runesHolder, Location location){

        // set portable to false -> not allow to pick and drop this item
        super("Runes", '$',false);

        // register runeSource and get the amount from runesHolder
        RunesManager.getInstance().registerRuneSource(this);
        this.runesAmount = RunesManager.getInstance().getRunes(runesHolder);
        RunesManager.getInstance().registerRunesHeld(runesHolder,0);  // reset runesHolder value

        // instance variable
        this.runesHolder = runesHolder;
        this.location = location;

        // allow this item to reset
        this.registerInstance();

        // add extra action that allow actor to perform
        this.addAction(new RecoverRunesAction(this));
    }

    /**
     * Accessor for runesHolder for this item
     *
     * @return the {@link Actor} who drops this item
     */
    public Actor getRunesHolder() {
        return runesHolder;
    }

    /**
     * Accessor for amount for this runes
     *
     * @return an integer that represents the amount of this runes
     */
    @Override
    public int generateRunes() {
        return runesAmount;
    }

    /**
     * Resets the Runes to their initial state.
     *
     * @param map the {@link GameMap} containing the Runes
     */
    @Override
    public String reset(GameMap map) {
        if (!runesHolder.hasCapability(Status.RESTING)) {
            RunesManager.getInstance().removeRuneSource(this);
            location.removeItem(this);
            return "\n" + this +  " is removed.";
        }
        return "";
    }
}
