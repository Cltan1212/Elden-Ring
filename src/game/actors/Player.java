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

	private final Menu menu = new Menu();

	private Location lastSiteOfLostGrace;
	private FlaskOfCrimsonTears flaskOfCrimsonTears;
	public CombatArchetypes role;

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints, CombatArchetypes role, Location lastSite) {
		super(name, displayChar, hitPoints);
		lastSiteOfLostGrace = lastSite;
		this.role = role;
		this.flaskOfCrimsonTears = new FlaskOfCrimsonTears();
		RunesManager.getInstance().registerRunesHeld(this, 0);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Status.CONSUMABLE);
		this.addCapability(Status.RESTABLE);
		resetMaxHp(role.getStartingHitPoint());  // to set starting hit point based on role
		this.addWeaponToInventory(role.getStartingWeapon()); // to set starting inventory based on role

		this.registerInstance(); // Register the Player created as resettable and add to the list of resettable.
	}

	/**
	 * Select and return an action to perform on the current turn.
	 *
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return the Action to be performed
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Display Hp and runes value
		display.println(name + " " + printHp() + ", runes: " + RunesManager.getInstance().getRunes(this));

		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		if(this.hasCapability(Status.CONSUMABLE)){
			actions.add(new ConsumeAction(flaskOfCrimsonTears));
		}

		return menu.showMenu(this, actions, display);
	}


	@Override
	public void reset(GameMap map) {
		this.resetMaxHp(this.getMaxHp());
	}

	public Location getLastSiteOfLostGrace() {
		return lastSiteOfLostGrace;
	}
}
