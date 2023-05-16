package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import game.runes.RuneSource;
import game.runes.RunesManager;
import game.utils.RandomNumberGenerator;

public class GoldenRunes extends ConsumableItem implements RuneSource {


    /**
     * Constructor.
     */
    public GoldenRunes() {
        super("Golden Runes", '*', true);
    }

    @Override
    public void consume(Actor actor) {
        RunesManager.getInstance().addRunes(actor,this.generateRunes());
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(200,10000);
    }
}