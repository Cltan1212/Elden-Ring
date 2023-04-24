package game.items;

import edu.monash.fit2099.engine.actors.Actor;

public class FlaskOfCrimsonTears extends ConsumableItem{
    protected int remainingConsume = 2;

    public FlaskOfCrimsonTears(){
        super("Flask Of Crimson Tears", 'f', false);}
    public FlaskOfCrimsonTears(String name, char displayChar, boolean portable){
        super(name, displayChar, portable);
    }

    @Override
    public String consume(Actor actor){
        String returnString = "";
        if (remainingConsume > 0){
            remainingConsume -= 1;
            actor.heal(250);
            returnString = actor + " consumed Flask Of Crimson Tears and restored 250 hit points.";
        }
        else{
            returnString = actor + " has reached maximum consumption of Flask Of Crimson Tears.";
        }
        return returnString;
    }

    @Override
    public void reset(){
        remainingConsume = 2;
    }
}
