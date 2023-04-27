package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.reset.Resettable;
import game.weapons.Grossmesser;

public class PileOfBones extends Enemy implements Resettable {

    private final Actor skeletalEnemy;
    private int remaining;

    public PileOfBones(Actor skeletalEnemy) {
        super("Pile Of Bones",'X',1);
        this.addWeaponToInventory(new Grossmesser());
        this.skeletalEnemy = skeletalEnemy;
        setRemainingDeath(3);
        skeletalEnemy.resetMaxHp(153);
    }

    public void setRemainingDeath(int remainingDeath) {
        this.remaining = remainingDeath;
    }


    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        remaining -= 1;
        if (remaining == 0){
            Location previousLocation = map.locationOf(this);
            map.removeActor(this);
            previousLocation.addActor(skeletalEnemy);
        }
        return new DoNothingAction();
    }

}
