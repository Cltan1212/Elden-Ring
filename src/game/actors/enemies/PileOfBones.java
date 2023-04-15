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
    private Actor saveActor; // turn back to their own status

    public PileOfBones(Actor saveActor){
        super("Pile Of Bones",'X',0);
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
            Location currentLocation = map.locationOf(pileOfBones);
            map.addActor(saveActor, currentLocation);
            map.removeActor(pileOfBones);
        }
        return new DoNothingAction();
    }
}
