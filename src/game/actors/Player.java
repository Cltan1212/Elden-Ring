package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.combat.CombatArchetypes;
import game.reset.Resettable;
import game.runes.Runes;
import game.runes.RunesManager;
import game.utils.MenuToDisplayClass;
import game.utils.Status;
import game.weapons.Club;
import game.weapons.GreatKnife;
import game.weapons.Uchigatana;
import game.combat.Bandit;
import game.combat.Sarumai;
import game.combat.Wretch;

import javax.swing.*;

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
	CombatArchetypes combatChoice;

	private static Player instance;

	public Runes runesItem; // use this for tracing
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

		runesItem = new Runes(0);
		this.addItemToInventory(runesItem);
		RunesManager.setPlayer(this);

		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Status.BUYING);
		this.addCapability(Status.SELLING);

		resetMaxHp(role.getStartingHitPoint());
		this.addWeaponToInventory(role.getStartingWeapon());

//		if (role == new Bandit()){
////			combatChoice = new Bandit();
//			resetMaxHp(combatChoice.getStartingHitPoint());
//			this.addWeaponToInventory(combatChoice.getStartingWeapon());  // Great Knife
//		} else if (choice == 's'){
//			combatChoice = new Sarumai();
//			resetMaxHp(combatChoice.getStartingHitPoint());
//			this.addWeaponToInventory(combatChoice.getStartingWeapon()); // Uchigatana
//		} else if (choice == 'w'){
//			combatChoice = new Wretch();
//			resetMaxHp(combatChoice.getStartingHitPoint());
//			this.addWeaponToInventory(combatChoice.getStartingWeapon());  // Club
//		}
	}

//	public static Player getInstance(String name, char displayChar, int hitPoints){
//		if (name == null){  // cuz when I create Player in enemy, the name will be null. so it will reference to the same Player object as defined in Application.java
//			return instance;
//		} else if (instance == null){
//			instance = new Player(name, displayChar, hitPoints);
//		}
//		return instance;


		//		if (instance == null){
//			instance = new Player(name, displayChar, hitPoints);
//		}


	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Display Hp and runes value
		display.println(name + " " + printHp() + ", runes: " + runesItem.getRunesValue());

		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}


	@Override
	public void reset() {}
}
