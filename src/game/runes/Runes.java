package game.runes;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.*;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.runesActions.DropRunesAction;
import game.actions.runesActions.PickUpRunesAction;
import game.actions.runesActions.TransferRunesAction;
import game.reset.Resettable;
import game.utils.Status;

import java.util.List;

public class Runes extends Item implements Resettable,Pickable,Dropable{

    private int runesValue;

    public Runes(int initialRunesValue) {
        super("Runes", '$', false);
        runesValue = initialRunesValue;
        this.addCapability(Status.TRADING);
    }

    @Override
    public PickUpAction getPickUpAction(Actor actor) {
        if (portable)
            return new PickUpRunesAction(this);
        return null;
    }

    @Override
    public DropAction getDropAction(Actor actor) {
        if (portable)
            return new DropRunesAction(this);
        return null;
    }

    public void setRunesValue(int runesValue) {
        this.runesValue = runesValue;
    }

    public void addRunes(int value) {
        runesValue += value;
    }

    public void subtractRunes(int value) {
        runesValue -= value;
    }

    public int getRunesValue() {
        return runesValue;
    }

//    @Override
//    public List<Action> getAllowableActions() {
//        return super.getAllowableActions();
//    }

    @Override
    public String pick(Actor actor, GameMap map) {
        RunesManager.addRunesValue(runesValue);
        Location location = map.locationOf(actor);
        location.removeItem(this);
        return actor + " picked up $ " + runesValue;
    }

    @Override
    public String drop(Actor actor, GameMap map) {
        RunesManager.subtractRunesValue(runesValue);
        Location location = map.locationOf(actor);
        location.addItem(this);
        return actor + " dropped $ " + runesValue;
    }
    @Override
    public void reset() {

    }
}
