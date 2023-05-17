package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.groundAction.ToLimgraveMapAction;
import game.actions.groundAction.ToRoundTableMapAction;
import game.actions.groundAction.ToStormveilCastleMapAction;
import game.utils.Status;

public class GoldenFogDoor extends Ground {
    /**
     * Constructor.
     */

    GameMap map;
    public GoldenFogDoor(GameMap thisMap) {
        super('D');
        map = thisMap;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();

        // only Player can travel to another map
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {

            if (location.x() == 6 && location.y() == 23) {  // from Limgrave to RoundTable Hold
                actions.add(new ToRoundTableMapAction(map, 9, 10));
            } else if (location.x() == 30 && location.y() == 0) {  // from Limgrave to Stormveil Castle
                actions.add(new ToStormveilCastleMapAction(map, 38, 23));
            } else if (location.x() == 9 && location.y() == 10){  // from RoundTable Hold to Limgrave
                actions.add(new ToLimgraveMapAction(map, 6, 23));
            } else if (location.x() == 38 && location.y() == 23){ // from Stormveil Castle to Limgrace
                actions.add(new ToLimgraveMapAction(map, 30,0));
            }
        }
        return actions;
    }
}