package game.actors.enemies.dogTypeEnemy;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.enemies.Enemy;
import game.actors.enemies.EnemyType;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.utils.RandomNumberGenerator;
import game.utils.Status;
import game.behaviours.WanderBehaviour;
import game.actions.actorActions.AttackAction;
import game.behaviours.Behaviour;

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
public class LoneWolf extends DogEnemy {

    public LoneWolf() {
        super("Lone Wolf", 'h', 102);

        // capabilities
        this.addCapability(EnemyType.DOG);
        this.addCapability(Status.HOSTILE_TO_SKELETAL_TYPE_ENEMY);
        this.addCapability(Status.HOSTILE_TO_WATER_TYPE_ENEMY);
    }


    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }
}
