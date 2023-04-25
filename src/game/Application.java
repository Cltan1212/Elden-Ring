package game;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.enemies.dog.LoneWolf;
import game.actors.Player;
import game.actors.MerchantKale;
import game.combat.Bandit;
import game.combat.CombatArchetypes;
import game.combat.Sarumai;
import game.combat.Wretch;
import game.grounds.Dirt;
import game.grounds.Floor;
import game.grounds.SiteOfLostGrace;
import game.grounds.Wall;
import game.grounds.environments.Graveyard;
import game.grounds.environments.GustOfWind;
import game.grounds.environments.PuddleOfWater;
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

//		MenuToDisplayClass menuDisplay = new MenuToDisplayClass();

		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Graveyard(), new GustOfWind(), new PuddleOfWater(), new SiteOfLostGrace());

		List<String> map = Arrays.asList(
				"..nnnn................................................~~~~~~~~~~~~~~~~~~~~~",
				"......................#####....######..................~~~~~~~~~~~~~~~~~~~~",
				"..nnnn................#..___....____#...................~~~~~~~~~~~~~~~~~~~",
				"..................................__#....................~~~~~~~~~~~~~~~~~~",
				"......................._____........#.....................~~~~~~~~~~~~~~~~~",
				"......................#............_#......................~~~~~~~~~~~~~~~~",
				"......................#...........###......................................",
				"...........................................................................",
				"...........................................................................",
				"~~~~~~~~~~~.......................###___###................................",
				"~~~~~~~~~~~~......................________#....nnnn........................",
				"~~~~~~~~~~~~~.....................#___U____................................",
				"~~~~~~~~~~~~......................#_______#....nnnn........................",
				"~~~~~~~~~~~.......................###___###................................",
				"~~~~~~~~~~..........................#___#..................................",
				"...........................................................................",
				"...........................................................................",
				"...........................................................................",
				"..####__##...........................................&&&......######..##...",
				"..#.....__...........................................&&&......#....____....",
				"..#___..............&&&..............................&&&........__.....#...",
				"..####__###.........&&&......................................._.....__.#...",
				"....................&&&.......................................###..__###...",
				"...........................................................................");

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

		HashMap<Character, CombatArchetypes> characterToRoleMap = new HashMap<Character, CombatArchetypes>();
		characterToRoleMap.put('s', new Sarumai());
		characterToRoleMap.put('b', new Bandit());
		characterToRoleMap.put('w', new Wretch());

		Display display = new Display();
		display.println("Select your role: ");
		for (Character key: characterToRoleMap.keySet()){
			display.println(key + ":" + characterToRoleMap.get(key));
		}
		char choiceChar = display.readChar();
		while (!characterToRoleMap.containsKey(choiceChar)){
			choiceChar = display.readChar();
		}


		// HINT: what does it mean to prefer composition to inheritance?
		Player player = new Player("Tarnished", '@', 300, characterToRoleMap.get(choiceChar));
//		Player player = Player.getInstance("Tarnished", '@', 300, c);
//		System.out.println(player.findCapabilitiesByType(Status.class));  // will return [HOSTILE_TO_ENEMY, BUYING, SELLING]
//		MerchantKale trader = new MerchantKale("Merchant Kale", 'K', 0);
		world.addPlayer(player, gameMap.at(36, 10));
		world.addPlayer(new MerchantKale(), gameMap.at(40, 12));




		world.run();
	}
}
