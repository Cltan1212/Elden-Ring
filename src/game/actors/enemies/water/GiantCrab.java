package game.actors.enemies.water;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.actorActions.AttackAction;
import game.actors.enemies.Enemy;
import game.behaviours.Behaviour;
import game.utils.Status;
import game.weapons.GiantCrabSlam;

import java.util.HashMap;
import java.util.Map;

public class GiantCrab extends WaterType {

    public GiantCrab() {
        super("Giant Crab", 'C', 407);
        this.addWeaponToInventory(new GiantCrabSlam());
        this.addCapability(Status.SLAMMING_ATTACK);
        this.setSpecialAttack("Slamming attack");

    }

    @Override
    public void reset() {

    }
}
