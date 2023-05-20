package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.actorActions.ConsumeAction;
import game.runes.RuneSource;
import game.runes.RunesManager;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

/**
 * Golden Runes
 * This class represents an item in the game
 *
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see ConsumableItem
 */

public class GoldenRunes extends ConsumableItem implements RuneSource {

    /**
     * The boolean indicating the status of adding Golden Runes into player inventory
     */
    private boolean added;

    /**
     * The consunme action of this consumable item.
     */
    private ConsumeAction consumeAction;

    /**
     * Constructor.
     *
     * @see ConsumeAction
     */
    public GoldenRunes() {
        super("Golden Runes", '*', true);
        this.added = false;
        this.consumeAction = new ConsumeAction(this);
        RunesManager.getInstance().registerRuneSource(this);
    }

    /**
     * Inform a carried Item of the passage of time.
     *
     * This method is called once per turn, if the Item is being carried.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {

        if(!this.added){
            this.added = true;
            this.addAction(consumeAction);
        }

    }

    /**
     * Inform an Item on the ground of the passage of time.
     * This method is called once per turn, if the item rests upon the ground.
     * @param currentLocation The location of the ground on which we lie.
     */
    @Override
    public void tick(Location currentLocation) {
        this.removeAction(consumeAction);
    }

    /**
     * A method for consuming Golden Runes
     * Can only be consumed once
     * Each time the player uses it, will add an amount of runes.
     *
     * @param actor The {@link Actor} using the Golden Runes
     */
    @Override
    public void consume(Actor actor) {
        RunesManager.getInstance().addRunes(actor, this.generateRunes());
        actor.removeItemFromInventory(this);
        this.removeAction(consumeAction);
    }

    /**
     * Generate a random amount of runes.
     *
     * @return an integer that represent an amount of runes
     * @see RuneSource
     */
    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(200,10000);
    }


}
