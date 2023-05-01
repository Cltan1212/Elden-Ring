package game.runes;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.*;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.runesActions.RecoverRunesAction;
import game.reset.Resettable;
import game.utils.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing items that can be used as Runes in the game world
 */

public class Runes extends Item implements RuneSource, Resettable{

    private final int runesAmount;
    private final Actor runesHolder;
    private final Location location;

    /** Constructor
     *
     * @param runesHolder the actor who drops this item
     * @param location the location this item present
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
     * @return the actor who drops this item
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
     *
     * @param map
     */
    @Override
    public void reset(GameMap map) {
        if (!runesHolder.hasCapability(Status.RESTING)) {
            RunesManager.getInstance().removeRuneSource(this);
            location.removeItem(this);
        }
    }
}
