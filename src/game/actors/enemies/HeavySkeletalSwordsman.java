package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.weapons.Grossmesser;

import static game.utils.RandomNumberGenerator.getRandomInt;

public class HeavySkeletalSwordsman extends Enemy {
    private final Weapon weapon = new Grossmesser();

    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman", 'q',153);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // add valid behaviour to the list of behaviours
        // get action from the behaviour list
        return null;
    }

    @Override
    public boolean successAttack() {
        return weapon.chanceToHit() <= getRandomInt(100);
    }

    @Override
    public void reset() {

    }
}
