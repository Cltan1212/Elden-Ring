package game.actors.allyInvader;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.AttackBehaviour;
import game.utils.Status;


/**
 * Class representing an Ally actor in the game world.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see AllyOrInvaderType
 */
public class Ally extends AllyOrInvaderType {

    /**
     * Constructor.
     *
     */
    public Ally() {
        super("Ally", 'A', 0);
        this.addCapability(Status.FRIENDLY);
        this.addCapability(Status.HOSTILE_TO_INVADERS);
        this.addCapability(Status.HOSTILE_TO_FLYING_TYPE_ENEMY);
        this.addCapability(Status.HOSTILE_TO_STORMVEIL_CASTLE_ENEMY);
        this.addCapability(Status.HOSTILE_TO_DOG_TYPE_ENEMY);
        this.addCapability(Status.HOSTILE_TO_SKELETAL_TYPE_ENEMY);
        this.addCapability(Status.HOSTILE_TO_WATER_TYPE_ENEMY);
    }

    // no runes generated for Ally

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        // allies can attack other hostile creatures
        ActionList actionList = new ActionList();
        if  (otherActor.hasCapability(Status.RESPAWNABLE) || otherActor.hasCapability(Status.HOSTILE_TO_ALLIES)){
            this.behaviours.put(3, new AttackBehaviour(otherActor));
        }
        return actionList;

    }


}
