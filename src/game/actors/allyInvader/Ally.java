package game.actors.allyInvader;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.attackActions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.utils.Status;

public class Ally extends AllyOrInvaderType {
    /**
     * Constructor.
     */
    public Ally() {
        super("Ally", 'A', 0);
        this.addCapability(Status.HOSTILE_TO_INVADERS);
    }

    // no runes generated for Ally

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        // allies can attack other hostile creatures
        ActionList actionList = new ActionList();
        if  (otherActor.hasCapability(Status.RESPAWNABLE) || otherActor.hasCapability(Status.HOSTILE_TO_ALLIES)){
            this.behaviours.put(0, new AttackBehaviour(otherActor));
        }
        return actionList;

    }


}
