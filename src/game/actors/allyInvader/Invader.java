package game.actors.allyInvader;


import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.attackActions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.runes.RuneSource;
import game.runes.RunesManager;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

/**
 * Class representing an Invader actor in the game world.
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see AllyOrInvaderType
 */
public class Invader extends AllyOrInvaderType implements RuneSource {


    /**
     * The status to indicate if invader is following the player.
     */
    public boolean following = false;


    /**
     * Constructor.
     */
    public Invader() {
        super("Invader", 'ඞ', 0);
        RunesManager.getInstance().registerRuneSource(this);
        this.addCapability(Status.HOSTILE_TO_ALLIES);
    }

    /**
     * The Invader can arracj any {@link Actor} that has the HOSTILE_TO_ENEMY and RESPAWNABLE capability
     *
     * @param otherActor the {@link Actor} that might be performing attack
     * @param direction  String representing the direction of the other {@link Actor}
     * @param map        current {@link GameMap}
     * @return a list of Actions that allowed otherActor to perform
     * @see AttackBehaviour
     * @see FollowBehaviour
     */

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();

        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            following = true;
            this.behaviours.put(0, new AttackBehaviour(otherActor));
            this.behaviours.put(1, new FollowBehaviour(otherActor));  // invader will follow the player
        }

        // invader can attack player, also other hostile creatures
        if (otherActor.hasCapability(Status.RESPAWNABLE) || otherActor.hasCapability(Status.HOSTILE_TO_INVADERS)){
            actions.add(new AttackAction(this, direction));
            this.behaviours.put(3, new AttackBehaviour(otherActor));
            for (WeaponItem weaponItem: otherActor.getWeaponInventory()){

                // attack action for normal weapon
                actions.add(new AttackAction(this, direction, weaponItem));
                // special skill for area attack
                actions.add(weaponItem.getSkill(otherActor));
                // special skill for target attack
                actions.add(weaponItem.getSkill(this, direction));
            }
        }
        return actions;
    }

    /**
     * Generate a random amount of runes.
     *
     * @return an integer that represent an amount of runes
     * @see RuneSource
     */
    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(1358,5578);
    }
}
