package game.actions.runesActions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.runes.Runes;

public class DropRunesAction extends DropAction {
    private final Runes runes;

    public DropRunesAction(Runes runes){
        super(runes);
        this.runes = runes;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        runes.drop(actor, map);
        return super.execute(actor, map);
    }

}
