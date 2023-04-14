package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class PileOfBones extends Actor {
    private int remaining;
    private PileOfBones pileOfBones;

    public PileOfBones(){
        setRemainingDeath(3);
    }


    public int getRemainingDeath() {
        return remaining;
    }

    public void setRemainingDeath(int remainingDeath) {
        this.remaining = remainingDeath;
    }

    public void counter(){
        remaining -= 1;
        if (remainingDeath == 0){
            // do something (get location and spawn heavy skeletal swordsman again)
        }
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        remaining -= 1;
        if (remaining == 0){
            Location newHeavy = map.locationOf(pileOfBones);
            map.addActor(new HeavySkeletalSwordsman(), newHeavy);
            map.removeActor(pileOfBones);
        }
        return new DoNothingAction();
    }
}
