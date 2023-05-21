package game.actors.traders;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.actorActions.ConversationAction;
import game.utils.Status;

public class FingerReaderEnia extends Actor implements Conversationable{

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
            actionList.add(new ConversationAction(otherActor, this));
        }
        return actionList;
    }

    @Override
    public String execute(Actor target) {
        if (!target.hasCapability(Status.SECRET_ENIA)){
            Display display = new Display();
            display.println("Finger Reader Enia:");
            display.println("Hey, I am Finger Reader Enia. I have a gift to you.");

            display.println("Tarnished:");
            display.println("a: Oh really? What is it?");
            display.println("b: I am not interested.");
            char choiceChar = display.readChar();

            if (choiceChar == 'a') {
                display.println("Finger Reader Enia:");
                display.println("I noticed that your HP is insufficient. Allow me to boost your HP.");

                display.println("Tarnished:");
                display.println("a: Sure.");
                display.println("b: I am not interested.");

                char choiceChar2 = display.readChar();

                if (choiceChar2 == 'a') {
                    target.addCapability(Status.SECRET_ENIA);
                    target.increaseMaxHp(100);
                    display.println("Finger Reader Enia:");
                    display.println("Make sure to keep an eye on your HP value! Best of luck!");
                }
            }

        } else{
            return "It appears that your HP has been enhanced previously.";
        }
        return "";
    }
}
