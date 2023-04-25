package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.combat.CombatArchetypes;
import game.items.FlaskOfCrimsonTears;
import game.reset.Resettable;
import game.runes.Runes;
import game.runes.RunesManager;
import game.utils.Status;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Player extends Actor implements Resettable {

	private final Menu menu = new Menu();

	private FlaskOfCrimsonTears flaskOfCrimsonTears;
	public CombatArchetypes role;

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints, CombatArchetypes role) {
		super(name, displayChar, hitPoints);
		this.role = role;
		this.flaskOfCrimsonTears = new FlaskOfCrimsonTears();
		RunesManager.getInstance().registerRunesHeld(this, 0);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Status.CONSUMABLE);
		resetMaxHp(role.getStartingHitPoint());  // to set starting hit point based on role
		this.addWeaponToInventory(role.getStartingWeapon()); // to set starting inventory based on role

		this.registerInstance(); // Register the Player created as resettable and add to the list of resettable.
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Display Hp and runes value
		display.println(name + " " + printHp() + ", runes: " + RunesManager.getInstance().getRunes(this));

		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}


	@Override
	public void reset() {}
}
