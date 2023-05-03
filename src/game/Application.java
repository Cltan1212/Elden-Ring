package game;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.MerchantKale;
import game.actors.Player;
import game.actors.enemies.enemyFactory.EastMapFactoryEnemy;
import game.actors.enemies.enemyFactory.WestMapFactoryEnemy;
import game.combat.Bandit;
import game.combat.CombatArchetypes;
import game.combat.Samurai;
import game.combat.Wretch;
import game.grounds.Dirt;
import game.grounds.Floor;
import game.grounds.SiteOfLostGrace;
import game.grounds.Wall;
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

		// map the character to its corresponding class
		HashMap<Character, CombatArchetypes> characterToRoleMap = new HashMap<Character, CombatArchetypes>();
		characterToRoleMap.put('s', new Samurai());
		characterToRoleMap.put('b', new Bandit());
		characterToRoleMap.put('w', new Wretch());

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
		int value = 0;
		for (int y = 9; y < 12; y++){
			value++;
			for (int x = 0; x < 10 + value; x ++){
				gameMap.at(x,y).setGround(new PuddleOfWater(new WestMapFactoryEnemy()));
			}
		}

		for (int y = 12; y < 15; y++){
			value--;
			for (int x = 0; x < 10 + value; x ++){
				gameMap.at(x,y).setGround(new PuddleOfWater(new WestMapFactoryEnemy()));
			}
		}

		for (int y = 0; y < 6; y++){
			for (int x = 54 + y; x < 54 + 21; x++){
				gameMap.at(x,y).setGround(new PuddleOfWater(new EastMapFactoryEnemy()));
			}
		}

		// gust of wind
		for (int y = 18; y < 21; y++){
			for (int x = 53; x < 56; x ++){
				gameMap.at(x,y).setGround(new GustOfWind(new EastMapFactoryEnemy()));
			}
		}

		for (int y = 20; y < 23; y++){
			for (int x = 20; x < 23; x++){
				gameMap.at(x,y).setGround(new GustOfWind(new WestMapFactoryEnemy()));
			}
		}

		// add GameMap to ResetManager
		ResetManager.getInstance().addSiteOfLostGrace(theFirstStep);
		ResetManager.getInstance().addMap(gameMap);
		world.run(); // run the whole game
	}
}
