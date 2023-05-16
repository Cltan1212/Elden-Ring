package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.enemies.skeletal.SkeletalType;
import game.reset.ResetManager;
import game.utils.RandomNumberGenerator;
import game.utils.Status;
import game.weapons.skeletalDropable.Grossmesser;

/**
 * Class representing a physical Pile of Bones in the game world.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see Enemy
 */
public class PileOfBones extends Enemy{

    private final SkeletalType skeletalEnemy;
    private int remaining;

    /**
     * Constructor.
     *
     * @param skeletalEnemy The {@link SkeletalType} enemy that turn into pile of bones.
     */
    public PileOfBones(SkeletalType skeletalEnemy) {
        super("Pile Of Bones",'X',1, 0);
        this.addCapability(Status.HOSTILE_TO_DOG_TYPE_ENEMY);
        this.addCapability(Status.HOSTILE_TO_WATER_TYPE_ENEMY);
        for (WeaponItem weaponItem: skeletalEnemy.getWeaponInventory()){
            System.out.println(weaponItem);
            this.addWeaponToInventory(weaponItem);
        }
        ResetManager.getInstance().registerResettable(this);
        this.skeletalEnemy = skeletalEnemy;
        this.remaining = 3;
        skeletalEnemy.resetMaxHp(153);
    }

    /**
     * At each turn, check if the Pile of Bones is not hit within the three turns
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        remaining -= 1;
        if (remaining == 0){
            Location previousLocation = map.locationOf(this);
            map.removeActor(this);
            previousLocation.addActor(skeletalEnemy);
        }
        return new DoNothingAction();
    }

    /**
     * Generate a random amount of runes.
     *
     * @return an integer that represent an amount of runes
     */
    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(35,892);
    }

}
