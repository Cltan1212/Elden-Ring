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
import game.runes.RunesManager;
import game.utils.Status;

/**
 * Class representing the Player. It implements the {@link Resettable} interface.
 * It carries around an item called {@link FlaskOfCrimsonTears} that can be consumed to restore its own hitPoints.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see Actor
 * @see Resettable
 *
 */
public class Player extends Actor implements Resettable {

	/**
	 * The {@link Menu} used by the Player for selecting actions.
	 */
	private final Menu menu = new Menu();

	/**
	 * The {@link CombatArchetypes} of the Player.
	 */
	public CombatArchetypes role;

	/**
	 * Creates a new Player object.
	 *
	 * @param name        the name of the Player
	 * @param displayChar the character used to represent the Player in the map
	 * @param hitPoints   the Player's hit points
	 * @param role        the {@link CombatArchetypes} of the Player
	 */
	public Player(String name, char displayChar, int hitPoints, CombatArchetypes role) {

		super(name, displayChar, hitPoints);
		this.role = role;
		RunesManager.getInstance().registerRunesHeld(this, 0);

		// capabilities
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Status.CONSUMABLE);
		this.addCapability(Status.RESTABLE);

		// set weapon and item
		maxHitPoints = role.getStartingHitPoint();
		this.resetMaxHp(getMaxHp());
		this.addItemToInventory(new FlaskOfCrimsonTears());
		this.addWeaponToInventory(role.getStartingWeapon());

		// for reset actions
		this.registerInstance();
	}

	/**
	 * Selects and returns an action for the Player to perform on their turn.
	 *
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return the Action to be performed
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		display.println(name + " " + printHp() + ", runes: " + RunesManager.getInstance().getRunes(this));

		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		return menu.showMenu(this, actions, display);
	}

	/**
	 * Resets the Player to their initial state.
	 *
	 * @param map the {@link GameMap} containing the Player
	 */
	@Override
	public String reset(GameMap map) {
		hitPoints = maxHitPoints;
		return "\n" + "Player is restored to full health.";
	}
}
