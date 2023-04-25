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

public class PileOfBones extends Enemy implements Resettable {

    private final Actor skeletalEnemy;
    private int remaining;

    public PileOfBones(Actor skeletalEnemy) {
        super("Pile Of Bones",'X',100);
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
            map.locationOf(this).addActor(skeletalEnemy);
            map.removeActor(this);
        }
        return new DoNothingAction();
    }

    @Override
    public void reset() {

    }
}
