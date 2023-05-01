package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.actorActions.ConsumeAction;
import game.reset.ResetManager;

/**
 * FlaskOfCrimsonTears
 * This class represents an item in the game
 * The starting weapon of the player
 * @see ConsumableItem
 */
public class FlaskOfCrimsonTears extends ConsumableItem{
    private final int maximumUse = 2;
    private int remainingConsume;
    private final int healPoints;

    /**
     * Constructor
     * Set the name, display charater and portability
     */
    public FlaskOfCrimsonTears(){
        super("Flask Of Crimson Tears", 'c', false);
        this.remainingConsume = maximumUse;
        this.healPoints = 250;
        this.addAction(new ConsumeAction(this));
        ResetManager.getInstance().registerResettable(this);
    }

    /**
     * A method for consuming Flask of Crimson Tears
     * Can only be consumed twice
     * Each time the player uses it, their health will be restored by 250 points
     * Display the message if the player has reached maximum consumpion
     * @param actor The player using the Flask of Crimson Tears
     */
    @Override
    public void consume(Actor actor){
        String returnString = "";
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
     * @param map the map in which the Flask Of Crimson is on
     */
    @Override
    public void reset(GameMap map){
        this.remainingConsume = maximumUse;
    }

}
