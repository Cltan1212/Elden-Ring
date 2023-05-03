package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.actorActions.RestAction;
import game.utils.Status;

/**
 * SiteOfLostGrace
 * The SiteOfLostGrace class is one of the ground in this game
 * It extends Ground class
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 * @see Ground
 */
public class SiteOfLostGrace extends Ground {

    /**
     * allow player to rest on it, when this happens, the entire game will be reset
     */
    private String name;

    /**
     * The x-coordinate of the location of SiteOfLostGrace
     */
    public int locationX;

    /**
     * The y-coordinate of the location of SiteOfLostGrace
     */
    public int locationY;

    /**
     * Constructor
     * @param name The name of the ground
     * @param locationX  The x-coordinate of the location of SiteOfLostGrace
     * @param locationY The y-coordinate of the location of SiteOfLostGrace
     */
    public SiteOfLostGrace(String name, int locationX, int locationY) {
        super('U');
        this.name = name;
        this.locationX = locationX;
        this.locationY = locationY;
    }

    /**
     * This method serve to check if an actor can enter the ground
     * @param actor the {@link Actor} to check
     * @return boolean, true if it can enter, false otherwise
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }

    /**
     * A method that allows adds {@link RestAction} as one of the allowable action for player to choose from
     * @param actor the {@link Actor} acting
     * @param location the current {@link Location}
     * @param direction the direction of the Ground from the {@link Actor}
     * @return a collection of actions
     * @see RestAction
     */
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actions = new ActionList();
        if (actor.hasCapability(Status.RESTABLE)){
            actions.add(new RestAction(this));     //WILL NEED TO DEPEND ON RESTACTION METHOD
        }
        return actions;

    }

    /**
     * ToString method
     * @return the name which is SiteOfLostGrace
     */
    @Override
    public String toString() {
        return this.name;
    }
}
