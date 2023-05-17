package game;

import java.util.HashMap;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Player;
import game.actors.enemies.enemyFactory.NorthEastMapFactory;
import game.actors.enemies.enemyFactory.NorthWestMapFactory;
import game.actors.enemies.enemyFactory.SouthEastFactory;
import game.actors.enemies.enemyFactory.SouthWestEnemy;
import game.actors.traders.FingerReaderEnia;
import game.actors.traders.MerchantKale;
import game.combat.*;
import game.grounds.*;
import game.grounds.environments.Graveyard;
import game.grounds.environments.GustOfWind;
import game.grounds.environments.PuddleOfWater;
import game.grounds.environments.ThunderStorm;
import game.grounds.stormveilCastle.Barrack;
import game.grounds.stormveilCastle.Cage;
import game.items.RemembranceOfTheGrafted;
import game.maps.Limgrave;
import game.maps.RoundTableHold;
import game.maps.StormVeilCastle;
import game.reset.ResetManager;
import game.utils.FancyMessage;
import game.weapons.GraftedDragon;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 */
public class Application {

	/**
	 * The application of the game engine
	 * @param args the command line arguments passed to the program
	 */

	public static void main(String[] args) {

		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(),
				new Cage(), new Barrack(), new Cliff(), new SummonSign());

		Limgrave limgrave = new Limgrave();
		RoundTableHold roundTableHold = new RoundTableHold();
		StormVeilCastle stormveilCastle = new StormVeilCastle();


		GameMap gameMap = new GameMap(groundFactory, limgrave.getMap());
		GameMap roundtableHoldMap = new GameMap(groundFactory, roundTableHold.getMap());
		GameMap stormveilCastleMap = new GameMap(groundFactory, stormveilCastle.getMap());


		world.addGameMap(gameMap);
		world.addGameMap(roundtableHoldMap);
		world.addGameMap(stormveilCastleMap);


		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		// map the character to its corresponding class
		HashMap<Character, CombatArchetypes> characterToRoleMap = new HashMap<Character, CombatArchetypes>();
		characterToRoleMap.put('s', new Samurai());
		characterToRoleMap.put('b', new Bandit());
		characterToRoleMap.put('w', new Wretch());
		characterToRoleMap.put('a', new Astrologer());
		characterToRoleMap.put('D', new Developer());

		// Display the role choices for user to select and pass the choiceChar to Player constructor
		Display display = new Display();
		display.println("Select your role: ");
		for (Character key: characterToRoleMap.keySet()){
			display.println(key + ":" + characterToRoleMap.get(key));
		}
		char choiceChar = display.readChar();
		while (!characterToRoleMap.containsKey(choiceChar)){
			choiceChar = display.readChar();
		}

		// site of lost grace
		SiteOfLostGrace theFirstStep = new SiteOfLostGrace("The First Step",38,11);
		gameMap.at(38,11).setGround(theFirstStep);

		// HINT: what does it mean to prefer composition to inheritance?
		Player player = new Player("Tarnished", '@', 300, characterToRoleMap.get(choiceChar));
		world.addPlayer(player, gameMap.at(36, 10));
		player.addItemToInventory(new RemembranceOfTheGrafted());
		player.addItemToInventory(new GraftedDragon());

		MerchantKale trader = new MerchantKale();
		gameMap.at(40,12).addActor(trader);

		FingerReaderEnia enia = new FingerReaderEnia();
		roundtableHoldMap.at(10, 2).addActor(enia);

		// GoldenFrogDoor
		GoldenFogDoor FogDoorToRound = new GoldenFogDoor(roundtableHoldMap);
		gameMap.at(6, 23).setGround(FogDoorToRound);
		GoldenFogDoor FogDoorToStorm = new GoldenFogDoor(stormveilCastleMap);
		gameMap.at(30, 0).setGround(FogDoorToStorm);

		// set the ground in roundtableHoldMap
		GoldenFogDoor FogDoorToLimgrave = new GoldenFogDoor(gameMap);
		roundtableHoldMap.at(9,10).setGround(FogDoorToLimgrave);
		stormveilCastleMap.at(38, 23).setGround(FogDoorToLimgrave);


		// graveyard
		// NORTH WEST
		for (int x = 2; x < 6; x ++){
			gameMap.at(x,0).setGround(new Graveyard(new NorthWestMapFactory()));
			gameMap.at(x,2).setGround(new Graveyard(new NorthWestMapFactory()));
		}

		// SOUTH EAST
		for (int x = 47; x < 51; x++){
			gameMap.at(x,10).setGround(new Graveyard(new SouthEastFactory()));
			gameMap.at(x,12).setGround(new Graveyard(new SouthEastFactory()));
		}

		// NORTH EAST
		for (int x = 50; x <= 54; x++) {
			gameMap.at(x, 5).setGround(new Graveyard(new NorthEastMapFactory()));
			gameMap.at(x, 6).setGround(new Graveyard(new NorthEastMapFactory()));
		}

		// SOUTH WEST
		for (int x = 30; x <= 35; x++){
			gameMap.at(x, 23).setGround(new Graveyard(new SouthWestEnemy()));
			gameMap.at(x, 23).setGround(new Graveyard(new SouthWestEnemy()));

		}

		// puddle of water
		// NORTH EAST
		for (int x = 54; x < 59; x ++){
			gameMap.at(x,0).setGround(new PuddleOfWater(new NorthEastMapFactory()));
			gameMap.at(x,1).setGround(new PuddleOfWater(new NorthEastMapFactory()));
			gameMap.at(x,2).setGround(new PuddleOfWater(new NorthEastMapFactory()));
			gameMap.at(x,3).setGround(new PuddleOfWater(new NorthEastMapFactory()));
		}

		// SOUTH WEST
		for (int y = 12; y < 15; y++){
			for (int x = 0; x < 4; x++){
				gameMap.at(x,y).setGround(new PuddleOfWater(new SouthWestEnemy()));
			}
		}

		// NORTH WEST
		for (int x = 16; x <= 20; x++) {
			gameMap.at(x, 2).setGround(new PuddleOfWater(new NorthWestMapFactory()));
			gameMap.at(x, 2).setGround(new PuddleOfWater(new NorthWestMapFactory()));
		}

		// SOUTH EAST
		for (int x = 65; x <= 70; x++) {
			gameMap.at(x, 23).setGround(new PuddleOfWater(new SouthEastFactory()));
		}

		// gust of wind
		// SOUTH EAST
		for (int y = 18; y < 21; y++){
			for (int x = 53; x < 56; x ++){
				gameMap.at(x,y).setGround(new GustOfWind(new SouthEastFactory()));
			}
		}

		// NORTH WEST
		for (int x = 10; x<= 14; x++){
			gameMap.at(x,4).setGround(new GustOfWind(new NorthWestMapFactory()));
			gameMap.at(x,5).setGround(new GustOfWind(new NorthWestMapFactory()));
		}

		// NORTH EAST
		for (int x = 40; x <= 44; x++){
			gameMap.at(x,1).setGround(new GustOfWind(new NorthEastMapFactory()));
			gameMap.at(x,2).setGround(new GustOfWind(new NorthEastMapFactory()));
		}

		// SOUTH WEST
		for (int x = 16; x <= 20; x++) {
			gameMap.at(x, 23).setGround(new GustOfWind(new SouthWestEnemy()));
		}

		// thunder storm
		// NORTH EAST
		for (int x = 1; x <= 5; x++){
			gameMap.at(x, 5).setGround(new ThunderStorm(new NorthEastMapFactory()));
			gameMap.at(x, 7).setGround(new ThunderStorm(new NorthEastMapFactory()));
		}

		// SOUTH EAST
		for (int x = 56; x <= 60; x++){
			gameMap.at(x, 10).setGround(new ThunderStorm(new SouthEastFactory()));
			gameMap.at(x, 12).setGround(new ThunderStorm(new SouthEastFactory()));
		}

		// NORTH WEST
		for (int x = 7; x <= 10; x++){
			gameMap.at(x, 16).setGround(new ThunderStorm(new NorthWestMapFactory()));
			gameMap.at(x, 17).setGround(new ThunderStorm(new NorthWestMapFactory()));
		}

		// SOUTH WEST
		for (int x = 70; x <= 73; x++) {
			gameMap.at(x, 17).setGround(new ThunderStorm(new SouthWestEnemy()));
			gameMap.at(x, 18).setGround(new ThunderStorm(new SouthWestEnemy()));
		}

		// add enemy for stormveil castle
		for (int x = 20; x <= 22; x++) {
			stormveilCastleMap.at(x, 17).setGround(new GustOfWind(new SouthWestEnemy()));
			stormveilCastleMap.at(x, 18).setGround(new GustOfWind(new SouthWestEnemy()));
		}


		// add GameMap to ResetManager
		ResetManager.getInstance().addSiteOfLostGrace(theFirstStep);
		ResetManager.getInstance().addMap(gameMap);
		world.run(); // run the whole game
	}
}
