package game.actions.runesActions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.runes.Runes;

public class PickUpRunesAction extends PickUpAction {

    private final Runes runes;
    public PickUpRunesAction(Runes runes){
        super(runes);
        this.runes = runes;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        runes.pick(actor, map);
        return super.execute(actor, map);
    }
}
