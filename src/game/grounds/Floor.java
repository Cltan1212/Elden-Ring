package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.utils.Status;

/**
 * A class that represents the floor inside a building.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * @see Ground
 *
 */
public class Floor extends Ground {

	/**
	 * Constructor
	 * Set the displayChar of ground
	 */
	public Floor() {
		super('_');
	}

	/**
	 *
	 * @param actor the Actor to check
	 * @return boolean indicating whether the actor can enter the ground or not
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
	}
}
