package game.actors.enemies.dog;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.utils.RandomNumberGenerator;
import game.behaviours.WanderBehaviour;
import game.utils.Status;

/**
 * BEHOLD, DOG!
 *
 * @author Adrian Kristanto
 * Modified by: Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @see DogType
 */
public class LoneWolf extends DogType {

    /**
     * Constructor.
     *
     * @see WanderBehaviour
     */
    public LoneWolf() {
        super("Lone Wolf", 'h', 102, 33);
        this.behaviours.put(999, new WanderBehaviour());
        this.addCapability(Status.HOSTILE_TO_STORMVEIL_CASTLE_ENEMY);
    }

    /**
     * The DoyType can be attacked by any {@link Actor} that has the HOSTILE_TO_ENEMY and HOSTILE_TO_DOG_TYPE_ENEMY capability
     *
     * @param otherActor the {@link Actor} that might be performing attack
     * @param direction  String representing the direction of the other {@link Actor}
     * @param map        current {@link GameMap}
     * @return a list of Actions that allowed otherActor to perform
     * @see AttackBehaviour
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        if (otherActor.hasCapability(Status.HOSTILE_TO_DOG_TYPE_ENEMY)){
            this.behaviours.put(3, new AttackBehaviour(otherActor));
        }
        return super.allowableActions(otherActor, direction, map);
    }

    /**
     * Creates and returns an {@link IntrinsicWeapon}.
     *
     * By default, the LoneWolf 'bites' for 95 damage.
     *
     * @return a freshly-instantiated {@link IntrinsicWeapon}
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }

    /**
     * Generate a random amount of runes.
     *
     * @return an integer that represent an amount of runes
     * @see game.runes.RuneSource
     */
    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(55,1470);
    }
}
