package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.reset.Resettable;
import game.runes.Runes;
import game.utils.MenuToDisplayClass;
import game.utils.Status;
import game.weapons.Club;
import game.weapons.GreatKnife;
import game.weapons.Uchigatana;
import game.combat.Bandit;
import game.combat.Sarumai;
import game.combat.Wretch;

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

	MenuToDisplayClass menuDisplay = new MenuToDisplayClass(); // for menu display for 3 different class/modes of game

	public Runes runesItem; // use this for tracing

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);

		runesItem = new Runes(0);
		this.addItemToInventory(runesItem);

		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Status.RESTING); // player has the capability of resting at SiteOfLostGrace

		char choice = menuDisplay.menuToDisplayClass();
		if (choice == 'b'){
			new Bandit();
			this.addWeaponToInventory(new GreatKnife());
		} else if (choice == 's'){
			new Sarumai();
			this.addWeaponToInventory(new Uchigatana());
		} else if (choice == 'w'){
			new Wretch();
			this.addWeaponToInventory(new Club());
		}
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}


	@Override
	public void reset() {}
}
