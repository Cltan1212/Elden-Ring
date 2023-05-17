package game.actors.enemies.stormveilCastleEnemy;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.enemies.dog.DogType;
import game.actors.enemies.stormveilCastleEnemy.StormveilCastleEnemy;
import game.behaviours.AttackBehaviour;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

public class Dog extends StormveilCastleEnemy{
    /**
     * Constructor.
     *
     */
    public Dog() {
        super("Dog",'a',104, 10);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        if (otherActor.hasCapability(Status.HOSTILE_TO_STORMVEIL_CASTLE_ENEMY)){
            this.behaviours.put(3, new AttackBehaviour(otherActor));
        }
        return super.allowableActions(otherActor, direction, map);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(101, "bites", 93);
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(52,1390);
    }
}
