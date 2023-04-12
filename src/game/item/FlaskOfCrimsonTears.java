package game.item;

import edu.monash.fit2099.engine.actors.Actor;

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
    public void reset() {
        // reset flask of crimson tears to maximum number of uses
        this.numOfUsesAvailable = 2;


    }


    @Override
    public void consumeItem(Actor actor) {
        // each time consumed, health will be restored by 250 points
        this.numOfUsesAvailable -= 1;
        actor.heal(250);
    }
}
