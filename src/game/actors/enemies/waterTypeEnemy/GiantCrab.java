package game.actors.enemies.waterTypeEnemy;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.AttackAction;
import game.actors.enemies.Enemy;
import game.actors.enemies.EnemyType;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.utils.Status;

import java.util.HashMap;
import java.util.Map;

public class GiantCrab extends WaterEnemy {

    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    public GiantCrab() {
        super("Giant Crab",'C',407);

        // add capabilities
        this.addCapability(EnemyType.WATER);
        this.addCapability(Status.HOSTILE_TO_SKELETAL_TYPE_ENEMY);
        this.addCapability(Status.HOSTILE_TO_DOG_TYPE_ENEMY);

        // add behaviours
        this.behaviours.put(999, new WanderBehaviour());
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }

}
