package game.actors.enemies.dog;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.actorActions.DespawnedAction;
import game.actors.Player;
import game.actors.enemies.Enemy;
import game.behaviours.*;
import game.utils.RandomNumberGenerator;
import game.utils.Status;
import game.actions.actorActions.AttackAction;

import java.util.HashMap;
import java.util.Map;

/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class LoneWolf extends Enemy {

    public LoneWolf() {
        super("Lone Wolf", 'h', 102);
    }


    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }



    @Override
    public void reset() {

    }
}
