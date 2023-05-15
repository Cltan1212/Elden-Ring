package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.actorActions.ConsumeAction;
import game.runes.RuneSource;
import game.runes.RunesManager;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

public class GoldenRunes extends ConsumableItem implements RuneSource {

    private boolean added;
    private ConsumeAction consumeAction;
    /**
     * Constructor.
     */
    public GoldenRunes() {
        super("Golden Runes", '*', true);
        this.added = false;
        this.consumeAction = new ConsumeAction(this);
    }

    // when actor carrying this item
    @Override
    public void tick(Location currentLocation, Actor actor) {

        if(!this.added){
            this.added = true;
            this.addAction(consumeAction);
        }

    }

    // ground
    @Override
    public void tick(Location currentLocation) {
        this.removeAction(consumeAction);
    }

    @Override
    public void consume(Actor actor) {
        RunesManager.getInstance().addRunes(actor,this.generateRunes());
        actor.removeItemFromInventory(this);
        this.removeAction(consumeAction);
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(200,10000);
    }


}
