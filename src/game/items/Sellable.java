package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import game.actions.runesActions.SellAction;

public interface Sellable {

    public SellAction createSellAction();
}
