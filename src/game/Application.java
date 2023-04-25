package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.MerchantKale;
import game.actors.enemies.dogTypeEnemy.LoneWolf;
import game.actors.Player;
import game.actors.enemies.enemySpawn.EnemyEast;
import game.actors.enemies.enemySpawn.EnemyWest;
import game.grounds.Dirt;
import game.grounds.Floor;
import game.grounds.SiteOfLostGrace;
import game.grounds.Wall;
import game.grounds.enviroments.Graveyard;
import game.grounds.enviroments.PuddleOfWater;
import game.utils.FancyMessage;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Application {

	public static void main(String[] args) {

		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor());


		List<String> map = Arrays.asList(
				"...........................................................................",
				"......................#####....######......................................",
				"......................#..___....____#......................................",
				"..................................__#......................................",
				"......................._____........#......................................",
				"......................#............_#......................................",
				"......................#...........###......................................",
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
				"..####__##....................................................######..##...",
				"..#.....__....................................................#....____....",
				"..#___..........................................................__.....#...",
				"..####__###..................................................._.....__.#...",
				"..............................................................###..__###...",
				"...........................................................................");

		// After Enemy class is implemented, can uncomment below to test
//		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Graveyard(), new GustOfWind(), new PuddleOfWater(), new SiteOfLostGrace());
//		List<String> map = Arrays.asList(
//				"..nnnn................................................~~~~~~~~~~~~~~~~~~~~~",
//				"......................#####....######..................~~~~~~~~~~~~~~~~~~~~",
//				"..nnnn................#..___....____#...................~~~~~~~~~~~~~~~~~~~",
//				"..................................__#....................~~~~~~~~~~~~~~~~~~",
//				"......................._____........#.....................~~~~~~~~~~~~~~~~~",
//				"......................#............_#......................~~~~~~~~~~~~~~~~",
//				"......................#...........###......................................",
//				"...........................................................................",
//				"...........................................................................",
//				"~~~~~~~~~~~.......................###___###................................",
//				"~~~~~~~~~~~~......................________#....nnnn........................",
//				"~~~~~~~~~~~~~.....................#___U____................................",
//				"~~~~~~~~~~~~......................#_______#....nnnn........................",
//				"~~~~~~~~~~~.......................###___###................................",
//				"~~~~~~~~~~..........................#___#..................................",
//				"...........................................................................",
//				"...........................................................................",
//				"...........................................................................",
//				"..####__##...........................................&&&......######..##...",
//				"..#.....__...........................................&&&......#....____....",
//				"..#___..............&&&..............................&&&........__.....#...",
//				"..####__###.........&&&......................................._.....__.#...",
//				"....................&&&.......................................###..__###...",
//				"...........................................................................");
//


		GameMap gameMap = new GameMap(groundFactory, map);
		world.addGameMap(gameMap);

		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		gameMap.at(23, 17).addActor(new LoneWolf());

		// HINT: what does it mean to prefer composition to inheritance?
		Player player = new Player("Tarnished", '@', 300);
		world.addPlayer(player, gameMap.at(36, 10));

		MerchantKale trader = new MerchantKale();
		world.addPlayer(trader, gameMap.at(38, 10));

//		// set graveyard
//		for (int x = 3; x <= 7; x++){
//			gameMap.at(x,1).setGround(new Graveyard(new EnemyWest()));
//			gameMap.at(x,3).setGround(new Graveyard(new EnemyWest()));
//		}
//
//		for (int x = 47; x <= 50; x++){
//			gameMap.at(x,1).setGround(new Graveyard(new EnemyEast()));
//			gameMap.at(x,3).setGround(new Graveyard(new EnemyEast()));
//		}
//
//		// set puddle of water
//		for (int x = 47; x <= 68; x++){
//			gameMap.at(x,1).setGround(new PuddleOfWater(new EnemyEast()));
//		}
//		for (int x = 48; x <= 68; x++){
//			gameMap.at(x,2).setGround(new PuddleOfWater(new EnemyEast()));
//		}
//		for (int x = 49; x <= 68; x++){
//			gameMap.at(x,3).setGround(new PuddleOfWater(new EnemyEast()));
//		}
//		for (int x = 50; x <= 68; x++){
//			gameMap.at(x,4).setGround(new PuddleOfWater(new EnemyEast()));
//		}
//		for (int x = 51; x <= 68; x++){
//			gameMap.at(x,5).setGround(new PuddleOfWater(new EnemyEast()));
//		}
//		for (int x = 52; x <= 68; x++){
//			gameMap.at(x,6).setGround(new PuddleOfWater(new EnemyEast()));
//		}
//
//		for (int x = ){
//			gameMap.at(x, y = )
//		}

		// set site of lost grace
		gameMap.at(38,12).setGround(new SiteOfLostGrace("The First Step"));


		world.run();
	}
}
