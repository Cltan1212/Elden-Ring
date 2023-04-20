package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.combat.Bandit;
import game.combat.Sarumai;
import game.combat.Wretch;
import game.reset.Resettable;
import game.runes.Runes;
import game.utils.MenuToDisplayClass;
import game.utils.Status;
import game.weapons.Club;
import game.weapons.GreatKnife;
import game.weapons.Uchigatana;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Player extends Actor implements Resettable {

	MenuToDisplayClass menuDisplay = new MenuToDisplayClass();

	private final Menu menu = new Menu();

	public Runes runesItem;

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
		this.addCapability(Status.HOSTILE_TO_ENEMY);

		char choice = selectClass();
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

	public char selectClass(){
		char choice = menuDisplay.menuToDisplayClass();
		return choice;
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
