package game.actions.actorActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.traders.Conversationable;
import game.utils.Status;

/**
 * An action representing a conversation between two actors.
 *
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see Action
 *
 */
public class ConversationAction extends Action {

    /**
     * The {@link Actor} to conversation with.
     */
    private final Actor target;

    /**
     * The {@link Conversationable} actor to perform conversation.
     */
    private final Conversationable actor;

    /**
     * Constructor for the ConversationAction class.
     *
     * @param target The target {@link Actor} to have a conversation with.
     * @param actor  The {@link Conversationable} actor initiating the conversation.
     */
    public ConversationAction(Actor target, Conversationable actor){
        this.target = target;
        this.actor = actor;
    }

    /**
     * Executes the conversation action by calling the execute method on the Conversationable actor,
     * passing the target Actor as a parameter.
     *
     * @param actor The {@link Actor} performing the conversation action.
     * @param map   The {@link GameMap} the Actor is on.
     * @return A string representing the result of the conversation.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return this.actor.execute(target);
    }

    /**
     * Provides a description of the conversation action for display in the game menu.
     *
     * @param actor The {@link Actor} performing the conversation action.
     * @return A string describing the conversation action with the target Actor.
     */
    @Override
    public String menuDescription(Actor actor) {
        return this.target + " make a conversation with " + this.actor;
    }
}
