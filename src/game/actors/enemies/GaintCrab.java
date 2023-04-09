package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.Behaviour;

import java.util.HashMap;
import java.util.Map;

public class GaintCrab extends Enemy {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    public GaintCrab() {
        super("Gaint Crab",'C', 407);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // TODO: add valid behaviour to the list of behaviours
        return new DoNothingAction();
    }

    @Override
    public boolean successAttack() {
        return false;
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }

    @Override
    public void reset() {

    }
}
