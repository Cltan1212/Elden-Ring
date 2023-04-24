package game.actors.enemies.skeletalTypeEnemy;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.AttackAction;
import game.actors.enemies.Enemy;
import game.actors.enemies.EnemyType;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.utils.Status;
import game.weapons.Grossmesser;

import java.util.HashMap;
import java.util.Map;

public class HeavySkeletalSwordsman extends SkeletalEnemy {

    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman",'q',153);

        // add capabilities
        this.addCapability(EnemyType.SKELETAL);
        this.addCapability(Status.HOSTILE_TO_DOG_TYPE_ENEMY);
        this.addCapability(Status.HOSTILE_TO_WATER_TYPE_ENEMY);

        // add weapon into weaponInventory
        this.addWeaponToInventory(new Grossmesser());

        // add behaviours this enemy can have
        this.behaviours.put(999, new WanderBehaviour());
    }
}
