package game.actions.runesActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.runes.Runes;
import game.runes.RunesManager;

public class RecoverRunesAction extends Action {

    private final Runes runes;
    public RecoverRunesAction(Runes runes){
        this.runes = runes;
    }
    @Override
    public String execute(Actor actor, GameMap map) {

        if (actor == runes.getRunesHolder())
            RunesManager.getInstance().registerRunesHeld(actor, runes.generateRunes());
        RunesManager.getInstance().removeRuneSource(runes);

        return actor + " recovered runes of amount $ " + runes.generateRunes();
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " recovered runes.";
    }
}
