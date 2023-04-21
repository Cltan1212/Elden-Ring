package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.utils.Status;
import game.weapons.Grossmesser;

import java.util.HashMap;
import java.util.Map;

public class HeavySkeletalSwordsman extends Enemy {

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

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return super.playTurn(actions, lastAction, map, display);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        return super.allowableActions(otherActor, direction, map);
    }
}
