package game.runes;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.*;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.runesActions.RecoverRunesAction;
import game.reset.Resettable;
import game.utils.Status;

import java.util.ArrayList;
import java.util.List;

public class Runes extends Item implements RuneSource, Resettable{

    private final int runesAmount;
    private final Actor runesHolder;
//    private final Location location;
    public Runes(Actor runesHolder){
        super("Runes", '$',false);
        this.runesAmount = RunesManager.getInstance().getRunes(runesHolder);
        this.runesHolder = runesHolder;
//        this.location = location;
        RunesManager.getInstance().registerRuneSource(this);
    }

    public Actor getRunesHolder() {
        return runesHolder;
    }

    @Override
    public List<Action> getAllowableActions() {

        List<Action> allowableActions = new ArrayList<>();
        allowableActions.add(new RecoverRunesAction(this));

        return allowableActions;
    }

    @Override
    public int generateRunes() {
        return runesAmount;
    }

    @Override
    public void reset(GameMap map) {
//        RunesManager.getInstance().removeRuneSource(this);
//        location.removeItem(this);
    }
}
