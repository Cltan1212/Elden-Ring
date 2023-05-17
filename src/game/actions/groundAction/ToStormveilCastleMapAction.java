package game.actions.groundAction;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class ToStormveilCastleMapAction extends ToMapAction {

    public ToStormveilCastleMapAction(GameMap map, int xInput, int yInput) {
        super(map, xInput, yInput);  // map -> the map to travel
    }
    @Override
    public String menuDescription(Actor actor) {
        return actor + " travels to Stormveil Castle";
    }
}
