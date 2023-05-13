package game.actors.traders;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Sellable;
import game.weapons.*;

import java.util.ArrayList;

public class FingerReaderEnia extends Actor {

    private final ArrayList<Sellable> sellableItemList;
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public FingerReaderEnia(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        sellableItemList = new ArrayList<>();
        sellableItemList.add(new Club());
        sellableItemList.add(new GreatKnife());
        sellableItemList.add(new Uchigatana());
        sellableItemList.add(new Grossmesser());
        sellableItemList.add(new Scimitar());
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }
}
