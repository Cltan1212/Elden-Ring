package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.groundAction.ToRoundTableMapAction;
import game.actions.groundAction.ToStormveilCastleMap;
import game.utils.Status;

public class GoldenFogDoor extends Ground {
    /**
     * Constructor.
     */
    public GoldenFogDoor() {
        super('D');
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();

        // only Player can travel to another map
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            if (location.x() == 6 && location.y() == 23) {
                // go roundtable Hold Map
                // should be an action
                actions.add(new ToRoundTableMapAction());
            } else if (location.x() == 30 && location.y() == 0) {
                actions.add(new ToStormveilCastleMap());
            }


        }
        return actions;
    }
}