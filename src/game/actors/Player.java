package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.actorActions.ConsumeAction;
import game.actions.actorActions.ResetAction;
import game.actions.actorActions.RestAction;
import game.combat.CombatArchetypes;
import game.grounds.SiteOfLostGrace;
import game.items.FlaskOfCrimsonTears;
import game.reset.Resettable;
import game.runes.Runes;
import game.runes.RunesManager;
import game.utils.Status;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around an item called FlaskOfCrimsonTears that can be consumed to restore its own hitPoints.
 *
 */
public class Player extends Actor implements Resettable {

	/**
	 * The menu used by the Player for selecting actions.
	 */
	private final Menu menu = new Menu();

	/**
	 * The CombatArchetypes of the Player.
	 */
	public CombatArchetypes role;

	/**
	 * Creates a new Player object.
	 *
	 * @param name        the name of the Player
	 * @param displayChar the character used to represent the Player in the map
	 * @param hitPoints   the Player's hit points
	 * @param role        the CombatArchetypes of the Player
	 */
	public Player(String name, char displayChar, int hitPoints, CombatArchetypes role) {
		super(name, displayChar, hitPoints);
		this.role = role;
		RunesManager.getInstance().registerRunesHeld(this, 0);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Status.CONSUMABLE);
		this.addCapability(Status.RESTABLE);
		resetMaxHp(role.getStartingHitPoint());
		this.addItemToInventory(new FlaskOfCrimsonTears());
		this.addWeaponToInventory(role.getStartingWeapon());
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
	 * @param map the map containing the Player
	 */
	@Override
	public void reset(GameMap map) {
		this.resetMaxHp(this.getMaxHp());
	}
}
