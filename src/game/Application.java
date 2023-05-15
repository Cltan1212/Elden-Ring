    package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actors.MerchantKale;
import game.actors.Player;
import game.actors.enemies.enemyFactory.EastMapFactoryEnemy;
import game.actors.enemies.enemyFactory.WestMapFactoryEnemy;
import game.combat.*;
import game.grounds.*;
import game.grounds.environments.Graveyard;
import game.grounds.environments.GustOfWind;
import game.grounds.environments.PuddleOfWater;
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

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor());
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
				"...........................................................................",
				"...........................................................................",
				"##############################################...##########################",
				"............................#................#.............................",
				"............................#................#.............................",
				"...........................................................................",
				"............................#................#.............................",
				"............................#................#.............................",
				"#####################..#############...############.####..#########...#####",
				"...............#............#................#............#................",
				"...............#.............................#............#................",
				"...............#..........................................#................",
				"...............#............#................#............#................",
				"#####...##########.....#############...#############..#############...#####",
				".._______..................................................................",
				"_____..._..____............................................................",
				".........____..............................................................",
				"...._______................................................................",
				"#####....##...###..#####...##########___###############......##.....####...",
				"...........................#...................#...........................",
				"...............................................#...........................",
				"...........................#...............................................",
				"...........................#...................#...........................");


		GameMap gameMap = new GameMap(groundFactory, map);
		GameMap roundtableHoldMap = new GameMap(groundFactory, roundtableHold);
		GameMap stormveilCastleMap = new GameMap(groundFactory, stormveilCastle);

//		ArrayList<GameMap> gameMapsAll = new ArrayList<GameMap>();
//		gameMapsAll.add(gameMap);
//		gameMapsAll.add(roundtableHoldMap);
//		gameMapsAll.add(stormveilCastleMap);

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

		// GoldenFrogDoor
		GoldenFogDoor FogDoorToRound = new GoldenFogDoor(roundtableHoldMap);
		gameMap.at(6, 23).setGround(FogDoorToRound);
		GoldenFogDoor FogDoorToStorm = new GoldenFogDoor(stormveilCastleMap);
		gameMap.at(30, 0).setGround(FogDoorToStorm);


		// graveyard
		for (int x = 2; x < 6; x ++){
			gameMap.at(x,0).setGround(new Graveyard(new WestMapFactoryEnemy()));
			gameMap.at(x,2).setGround(new Graveyard(new WestMapFactoryEnemy()));
		}

		for (int x = 47; x < 51; x++){
			gameMap.at(x,10).setGround(new Graveyard(new EastMapFactoryEnemy()));
			gameMap.at(x,12).setGround(new Graveyard(new EastMapFactoryEnemy()));
		}

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
		for (int x = 54; x < 59; x ++){
			gameMap.at(x,0).setGround(new PuddleOfWater(new EastMapFactoryEnemy()));
			gameMap.at(x,1).setGround(new PuddleOfWater(new EastMapFactoryEnemy()));
			gameMap.at(x,2).setGround(new PuddleOfWater(new EastMapFactoryEnemy()));
			gameMap.at(x,3).setGround(new PuddleOfWater(new EastMapFactoryEnemy()));
		}



		// new added
		for (int y = 12; y < 15; y++){
			for (int x = 0; x < 4; x++){
				gameMap.at(x,y).setGround(new PuddleOfWater(new WestMapFactoryEnemy()));
			}
		}

		// gust of wind
		for (int y = 18; y < 21; y++){
			for (int x = 53; x < 56; x ++){
				gameMap.at(x,y).setGround(new GustOfWind(new EastMapFactoryEnemy()));
			}
		}

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



		// add GameMap to ResetManager
		ResetManager.getInstance().addSiteOfLostGrace(theFirstStep);
		ResetManager.getInstance().addMap(gameMap);
		world.run(); // run the whole game
	}
}
