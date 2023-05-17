package game.actions.resetActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.resetActions.ResetAction;
import game.grounds.SiteOfLostGrace;
import game.reset.ResetManager;
import game.utils.Status;

/**
 * Special action for an {@link Actor} to rest at a Site of Lost Grace.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see Action
 */
public class RestAction extends Action {

    private SiteOfLostGrace siteOfLostGrace;

    /**
     * Constructor.
     *
     * @param siteOfLostGrace the {@link SiteOfLostGrace} where the {@link Actor} will rest
     *
     */
    public RestAction(SiteOfLostGrace siteOfLostGrace){
        this.siteOfLostGrace = siteOfLostGrace;
    }

    /**
     * Adds the {@link SiteOfLostGrace} to the list of visited sites, makes the actor rest, and executes a ResetAction.
     * Removes the resting capability after the actor is done resting.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a String indicating that the actor rested at the Site of Lost Grace
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        ResetManager.getInstance().addSiteOfLostGrace(siteOfLostGrace);
        actor.addCapability(Status.RESTING);
        new ResetAction().execute(actor, map);
        actor.removeCapability(Status.RESTING);
        return actor + " rested at " + siteOfLostGrace;
    }

    /**
     * A String indicating that the {@link Actor} can rest at the {@link SiteOfLostGrace}.
     *
     * @param actor the {@link Actor} that can rest at the {@link SiteOfLostGrace}
     * @return a String indicating that the actor can rest at the Site of Lost Grace
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " rests at " + siteOfLostGrace;
    }


}
