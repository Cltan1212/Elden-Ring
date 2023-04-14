package game.item;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class FlaskOfCrimsonTears extends ConsumableItem {


    // starting weapon of player
    // player cannot drop flask of crimson tears
    // the item can be consumed twice (max uses) & each time uses health restored by 250 points

    private int numOfUsesAvailable;

    /***
     * Constructor.
     */
    public FlaskOfCrimsonTears() {
        super("Flask of Crimson Tears", 'f', false);
        this.numOfUsesAvailable = 2;

    }

    @Override
    public void reset(GameMap map) {
        // reset flask of crimson tears to maximum number of uses
        this.numOfUsesAvailable = 2;


    }


    @Override
    public void consumeItem(Actor actor) {
        // each time consumed, health will be restored by 250 points
        this.numOfUsesAvailable -= 1;
        actor.heal(250);
    }

    // display number of uses the Flask of Crimson Tears has left on the console

}
