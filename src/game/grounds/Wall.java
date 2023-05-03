package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * @see Ground
 */
public class Wall extends Ground {

	/**
	 * Constructor
	 * Set the display char for Wwall
	 */

	public Wall() {
		super('#');
	}

	/**
	 * Method to check if the actor can enter the ground or not
	 * @param actor the Actor to check
	 * @return boolean to indicate whether they can enter or not
	 */
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}

	/**
	 * Method to indicate if can block thrown objects or not
	 * @return boolean to indicate whether it blocks or not
	 */
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
