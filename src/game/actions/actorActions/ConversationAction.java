package game.actions.actorActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.traders.Conversationable;
import game.utils.Status;

public class ConversationAction extends Action {

    private final Actor target;
    private final Conversationable actor;

    public ConversationAction(Actor target, Conversationable actor){
        this.target = target;
        this.actor = actor;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        return this.actor.execute(target);
    }

    @Override
    public String menuDescription(Actor actor) {
        return this.target + " make a conversation with " + this.actor;
    }
}
