package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviour.Behaviour;
import game.behaviour.WanderBehaviour;

import java.util.HashMap;
import java.util.Map;

public class GiantCrab extends Enemy {

    // represented by C
    // Giant crab may decide to slamm all creatues within the surrounding
    // Slamming all creatures in their surroundings is the special skill of Giant Crab
    // can drop any amount of runes between 318, 4961
    private Map<Integer, Behaviour> behaviours = new HashMap<>();
    /**
     * Constructor.
     *

     */
    public GiantCrab() {
        super("Giant Crab", 'C', 407);
        this.behaviours.put(999, new WanderBehaviour());
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slam", 90);
    }

    @Override
    public void reset(GameMap map) {

    }
}
