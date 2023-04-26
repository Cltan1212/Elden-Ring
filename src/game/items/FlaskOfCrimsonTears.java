package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.actorActions.ConsumeAction;
import game.reset.ResetManager;

public class FlaskOfCrimsonTears extends ConsumableItem{
    private final int maximumUse = 2;
    private int remainingConsume;
    private final int healPoints;
    public FlaskOfCrimsonTears(){
        super("Flask Of Crimson Tears", 'c', false);
        this.remainingConsume = maximumUse;
        this.healPoints = 250;
        this.addAction(new ConsumeAction(this));
        ResetManager.getInstance().registerResettable(this);
    }


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

    @Override
    public String toString(){
        return super.toString() + " (" + remainingConsume + "/" + maximumUse + ")";
    }

    @Override
    public void reset(GameMap map){
        this.remainingConsume = maximumUse;
    }

}
