package game.actions.actorActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.utils.Status;

public class ConversationAction extends Action {

    public Actor target;

    public ConversationAction(Actor target){
        this.target = target;
    }
    @Override
    public String execute(Actor actor, GameMap map) {

        if (!target.hasCapability(Status.SECRET_ENIA)){
            Display display = new Display();
            display.println("Finger Reader Enia:");
            display.println("Hey, I am Finger Reader Enia. I have a give to you.");

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

    @Override
    public String menuDescription(Actor actor) {
        return this.target + " make a conversation with " + actor;
    }
}
