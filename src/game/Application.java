    package game;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.traders.MerchantKale;
import game.actors.Player;
import game.actors.enemies.enemyFactory.NorthEastMapFactory;
import game.actors.enemies.enemyFactory.NorthWestMapFactory;
import game.actors.enemies.enemyFactory.SouthEastFactory;
import game.actors.enemies.enemyFactory.SouthWestEnemy;
import game.combat.*;
import game.grounds.*;
import game.grounds.environments.Graveyard;
import game.grounds.environments.GustOfWind;
import game.grounds.environments.PuddleOfWater;
import game.grounds.environments.ThunderStorm;
import game.grounds.stormveilCastle.Barrack;
import game.grounds.stormveilCastle.Cage;
import game.reset.ResetManager;
import game.utils.FancyMessage;

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

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Cliff(), new Cage(), new Barrack());
//
//
//		List<String> map = Arrays.asList(
//				"...........................................................................",
//				"......................#####....######......................................",
//				"......................#..___....____#......................................",
//				"..................................__#......................................",
//				"......................._____........#......................................",
//				"......................#............_#......................................",
//				"......................#...........###......................................",
//				"...........................................................................",
//				"...........................................................................",
//				"..................................###___###................................",
//				"..................................________#................................",
//				"..................................#________................................",
//				"..................................#_______#................................",
//				"..................................###___###................................",
//				"....................................#___#..................................",
//				"...........................................................................",
//				"...........................................................................",
//				"...........................................................................",
//				"..####__##....................................................######..##...",
//				"..#.....__....................................................#....____....",
//				"..#___..........................................................__.....#...",
//				"..####__###..................................................._.....__.#...",
//				"..............................................................###..__###...",
//				"...........................................................................");

		List<String> map = Arrays.asList(
				"......................#.............#......................................",
				"......................#.............#......................................",
				"......................#..___....____#......................................",
				"......................#...........__#......................................",
				"......................#_____........#......................................",
				"......................#............_#......................................",
				"......................######...######......................................",
				"...........................................................................",
				"...........................................................................",
				"..................................###___###................................",
				"..................................________#................................",
				"..................................#________................................",
				"..................................#_______#................................",
				"..................................###___###................................",
				"....................................#___#..................................",
				"...........................................................................",
				"...........................................................................",
				"...........................................................................",
				"#####___#####.................................................######..##...",
				"____________#.................................................#....____....",
				"____________#...................................................__.....#...",
				"____________#................................................._.....__.#...",
				"____________#.................................................###..__###...",
				"____________#..............................................................");

		List<String> roundtableHold = Arrays.asList(
				"##################",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"########___#######");

		List<String> stormveilCastle = Arrays.asList(
				"...........................................................................",
				"..................<...............<........................................",
				"...........................................................................",
				"##############################################...##########################",
				"............................#................#.......B..............B......",
				".....B...............B......#................#.............................",
				"...............................<.........<.................................",
				".....B...............B......#................#.......B..............B......",
				"............................#................#.............................",
				"#####################..#############...############.####..#########...#####",
				"...............#++++++++++++#................#++++++++++++#................",
				"...............#++++++++++++...<.........<...#++++++++++++#................",
				"...............#++++++++++++..................++++++++++++#................",
				"...............#++++++++++++#................#++++++++++++#................",
				"#####...##########.....#############...#############..#############...#####",
				".._______........................B......B........................B.....B...",
				"_____..._..____..............<..............<..............................",
				".........____..............................................................",
				"...._______..................<..............<....................<.....<...",
				"#####....##...###..#####...##########___###############......##.....####...",
				"+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++....................#+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++#....................+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++");



		GameMap gameMap = new GameMap(groundFactory, map);
		GameMap roundtableHoldMap = new GameMap(groundFactory, roundtableHold);
		GameMap stormveilCastleMap = new GameMap(groundFactory, stormveilCastle);

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

		MerchantKale trader = new MerchantKale();
		gameMap.at(40,12).addActor(trader);

		SummonSign summonSign = new SummonSign();
		gameMap.at(28, 8).setGround(summonSign);
		gameMap.at(35, 15).setGround(summonSign);
		gameMap.at(66, 16).setGround(summonSign);

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
		for (int y = 18; y < 21; y++){
			for (int x = 53; x < 56; x ++){
				gameMap.at(x,y).setGround(new GustOfWind(new SouthEastFactory()));
			}
		}

		for (int x = 10; x<= 14; x++){
			gameMap.at(x,4).setGround(new GustOfWind(new NorthWestMapFactory()));
			gameMap.at(x,5).setGround(new GustOfWind(new NorthWestMapFactory()));
		}

		for (int x = 40; x <= 44; x++){
			gameMap.at(x,1).setGround(new GustOfWind(new NorthEastMapFactory()));
			gameMap.at(x,2).setGround(new GustOfWind(new NorthEastMapFactory()));
		}

		for (int x = 16; x <= 20; x++) {
			gameMap.at(x, 23).setGround(new GustOfWind(new SouthEastFactory()));
		}

		// thunder storm
		for (int x = 1; x <= 5; x++){
			gameMap.at(x, 5).setGround(new ThunderStorm(new NorthEastMapFactory()));
			gameMap.at(x, 7).setGround(new ThunderStorm(new NorthEastMapFactory()));
		}
		for (int x = 56; x <= 60; x++){
			gameMap.at(x, 10).setGround(new ThunderStorm(new SouthEastFactory()));
			gameMap.at(x, 12).setGround(new ThunderStorm(new SouthEastFactory()));
		}

		for (int x = 7; x <= 10; x++){
			gameMap.at(x, 16).setGround(new ThunderStorm(new SouthWestEnemy()));
			gameMap.at(x, 17).setGround(new ThunderStorm(new SouthWestEnemy()));
		}

		for (int x = 70; x <= 73; x++) {
			gameMap.at(x, 17).setGround(new ThunderStorm(new SouthWestEnemy()));
			gameMap.at(x, 18).setGround(new ThunderStorm(new SouthWestEnemy()));
		}

		// add enemy for stormveil castle
		for (int x = 20; x <= 24; x++) {
			stormveilCastleMap.at(20, 17).setGround(new GustOfWind(new SouthWestEnemy()));
			stormveilCastleMap.at(20, 19).setGround(new GustOfWind(new SouthWestEnemy()));
		}


//		// graveyard
//		for (int x = 2; x < 6; x ++){
//			gameMap.at(x,0).setGround(new Graveyard(new WestMapFactoryEnemy()));
//			gameMap.at(x,2).setGround(new Graveyard(new WestMapFactoryEnemy()));
//		}
//
//		for (int x = 47; x < 51; x++){
//			gameMap.at(x,10).setGround(new Graveyard(new EastMapFactoryEnemy()));
//			gameMap.at(x,12).setGround(new Graveyard(new EastMapFactoryEnemy()));
//		}

		// puddle of water
//		int value = 0;
//		for (int y = 9; y < 12; y++){
//			value++;
//			for (int x = 0; x < 10 + value; x ++){
//				gameMap.at(x,y).setGround(new PuddleOfWater(new WestMapFactoryEnemy()));
//			}
//		}
//
//		for (int y = 12; y < 15; y++){
//			value--;
//			for (int x = 0; x < 10 + value; x ++){
//				gameMap.at(x,y).setGround(new PuddleOfWater(new WestMapFactoryEnemy()));
//			}
//		}

//		for (int y = 0; y < 6; y++){
//			for (int x = 54 + y; x < 54 + 21; x++){
//				gameMap.at(x,y).setGround(new PuddleOfWater(new EastMapFactoryEnemy()));
//			}
//		}
//		for (int x = 54; x < 59; x ++){
//			gameMap.at(x,0).setGround(new PuddleOfWater(new EastMapFactoryEnemy()));
//			gameMap.at(x,1).setGround(new PuddleOfWater(new EastMapFactoryEnemy()));
//			gameMap.at(x,2).setGround(new PuddleOfWater(new EastMapFactoryEnemy()));
//			gameMap.at(x,3).setGround(new PuddleOfWater(new EastMapFactoryEnemy()));
//		}



//		// new added
//		for (int y = 12; y < 15; y++){
//			for (int x = 0; x < 4; x++){
//				gameMap.at(x,y).setGround(new PuddleOfWater(new WestMapFactoryEnemy()));
//			}
//		}

		// gust of wind
//		for (int y = 18; y < 21; y++){
//			for (int x = 53; x < 56; x ++){
//				gameMap.at(x,y).setGround(new GustOfWind(new EastMapFactoryEnemy()));
//			}
//		}

//		for (int y = 20; y < 23; y++){
//			for (int x = 20; x < 23; x++){
//				gameMap.at(x,y).setGround(new GustOfWind(new WestMapFactoryEnemy()));
//			}
//		}

		// cliff (new added)
		int value = 0;
		for (int x =0; x < 4; x++){
			gameMap.at(18 + value, 18).setGround(new Cliff());
			gameMap.at(19 + value, 20).setGround(new Cliff());
			gameMap.at(8+ value, 9).setGround(new Cliff());
			gameMap.at(8 + value, 10).setGround(new Cliff());
			value++;
		}

		value = 0;
		for (int x= 0; x<3; x++){
			gameMap.at(12 + value, 10).setGround(new Cliff());
			gameMap.at(10+ value, 11).setGround(new Cliff());
			gameMap.at(12 + value, 12).setGround(new Cliff());
			gameMap.at(63 + value, 0).setGround(new Cliff());
			gameMap.at(66 + value, 4).setGround(new Cliff());
			gameMap.at(67 + value, 5).setGround(new Cliff());
			gameMap.at(44 + value, 18).setGround(new Cliff());
			gameMap.at(47 + value, 19).setGround(new Cliff());
			gameMap.at(48+ value, 22).setGround(new Cliff());
			value++;
		}

		value = 0;
		for (int x =0; x < 2; x++){
			gameMap.at(12 + value, 14).setGround(new Cliff());
			gameMap.at(14 + value, 16).setGround(new Cliff());
			gameMap.at(18 + value, 19).setGround(new Cliff());
			gameMap.at(24 + value, 21).setGround(new Cliff());
			gameMap.at(27 + value, 23).setGround(new Cliff());
			gameMap.at(46 + value, 17).setGround(new Cliff());
			gameMap.at(50 + value,21).setGround(new Cliff());
			gameMap.at(65 + value, 3).setGround(new Cliff());
			value++;
		}
		value = 0;
		for (int x= 0; x<5; x++) {
			gameMap.at(60+ value, 1).setGround(new Cliff());
			gameMap.at(62+ value, 2).setGround(new Cliff());
			value++;
		}

		// those alone Cliff
		gameMap.at(13,13).setGround(new Cliff());
		gameMap.at(14,15).setGround(new Cliff());
		gameMap.at(19, 21).setGround(new Cliff());
		gameMap.at(23, 22).setGround(new Cliff());
		gameMap.at(26, 22).setGround(new Cliff());
		gameMap.at(49, 20).setGround(new Cliff());

		// Add Cliff at Stormveil Castle Map
		// 26
		value = 0;
		for (int x = 0; x<27; x++){
			stormveilCastleMap.at(value, 20).setGround(new Cliff());
			stormveilCastleMap.at(value, 21).setGround(new Cliff());
			stormveilCastleMap.at(value, 22).setGround(new Cliff());
			stormveilCastleMap.at(value, 23).setGround(new Cliff());
			stormveilCastleMap.at(48 + value, 20).setGround(new Cliff());
			stormveilCastleMap.at(48 + value, 21).setGround(new Cliff());
			stormveilCastleMap.at(48 + value, 22).setGround(new Cliff());
			stormveilCastleMap.at(48 + value, 23).setGround(new Cliff());
			value++;
		}

		// 12
		value = 0;
		for (int x = 0; x<12; x++){
			stormveilCastleMap.at(16 + value, 10).setGround(new Cliff());
			stormveilCastleMap.at(16 + value, 11).setGround(new Cliff());
			stormveilCastleMap.at(16 + value, 12).setGround(new Cliff());
			stormveilCastleMap.at(16 + value, 13).setGround(new Cliff());
			stormveilCastleMap.at(46 + value, 10).setGround(new Cliff());
			stormveilCastleMap.at(46 + value, 11).setGround(new Cliff());
			stormveilCastleMap.at(46 + value, 12).setGround(new Cliff());
			stormveilCastleMap.at(46 + value, 13).setGround(new Cliff());
			value++;
		}


		// add GameMap to ResetManager
		ResetManager.getInstance().addSiteOfLostGrace(theFirstStep);
		ResetManager.getInstance().addMap(gameMap);
		world.run(); // run the whole game
	}
}
