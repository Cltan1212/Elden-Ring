package game.actions.runesActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.runes.Runes;
import game.runes.RunesManager;
import game.utils.Status;

public class TransferRunesAction extends Action {
    private final Actor target;
    private final Runes runes;

    public TransferRunesAction(Runes runes, Actor target){
        this.runes = runes;
        this.target = target;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        if (target.hasCapability(Status.HOSTILE_TO_ENEMY))
            RunesManager.addRunesValue(runes.getRunesValue());
        return target +  " has successfully defeated " + actor + " !";
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
