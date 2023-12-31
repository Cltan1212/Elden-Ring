package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.actorActions.ConsumeAction;
import game.reset.ResetManager;
import game.utils.Status;

/**
 * FlaskOfCrimsonTears
 * This class represents an item in the game
 * The starting weapon of the player
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see ConsumableItem
 */
public class FlaskOfCrimsonTears extends ConsumableItem{
    private final int healPoints;

    /**
     * Constructor
     * Set the name, display charater and portability
     */
    public FlaskOfCrimsonTears(){
        super("Flask Of Crimson Tears", 'c', false);
        this.addAction(new ConsumeAction(this));
        this.maximumUse = 2;
        this.remainingConsume = maximumUse;
        this.healPoints = 250;

    }

    /**
     * A method for consuming Flask of Crimson Tears
     * Can only be consumed twice
     * Each time the player uses it, their health will be restored by 250 points
     * Display the message if the player has reached maximum consumption
     * @param actor The {@link Actor} using the Flask of Crimson Tears
     */
    @Override
    public void consume(Actor actor){
        if (remainingConsume > 0){
            remainingConsume -= 1;
            actor.heal(healPoints);
        }
        else{
            new Display().println(actor + " has reached maximum consumption.");
        }
    }

    /**
     * ToString method
     * @return a descriptive string
     */
    @Override
    public String toString(){
        return super.toString() + " (" + remainingConsume + "/" + maximumUse + ")";
    }

    /**
     * A method that reset the remaining consume to maximum consume
     * @param map the {@link GameMap} in which the consumable item.
     */
    @Override
    public String reset(GameMap map){
        ResetManager.getInstance().updateResettable(this);
        this.remainingConsume = maximumUse;
        return "\n" + "Flask of Crimson Tears reset to maximum consumption";
    }
}
