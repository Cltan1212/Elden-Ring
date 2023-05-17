package game.actors.traders;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.actorActions.ConversationAction;
import game.items.Purchasable;
import game.items.Sellable;
import game.utils.Status;
import game.weapons.*;

import java.util.ArrayList;

public class FingerReaderEnia extends Actor {

    /**
     * Constructor.
     */
    public FingerReaderEnia() {
        super("Finger Reader Enia", 'E', 100);
        this.addCapability(Status.EXCHANGE);
        this.addCapability(Status.SELL);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actionList = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actionList.add(new ConversationAction(otherActor));
        }
        return actionList;
    }
}
