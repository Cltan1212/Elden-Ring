package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.behaviours.WanderBehaviour;
import game.actions.AttackAction;
import game.utils.Status;
import game.behaviours.Behaviour;

import java.util.HashMap;
import java.util.Map;

import static game.utils.RandomNumberGenerator.getRandomInt;

/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class LoneWolf extends Enemy{
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    public LoneWolf() {
        super("Lone Wolf", 'h', 102);
        this.behaviours.put(999, new WanderBehaviour());
        setAttackAccuracy(95);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }

    @Override
    public boolean successAttack(){
        return getRandomInt(100) <= this.getAttackAccuracy();
    }

    @Override
    public void reset() {

    }
}
