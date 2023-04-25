package game.actors.enemies.skeletalTypeEnemy;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.enemies.Enemy;
import game.actors.enemies.PileOfBones;
import game.runes.RunesManager;
import game.utils.RandomNumberGenerator;

public abstract class SkeletalEnemy extends Enemy {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public SkeletalEnemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        RunesManager.getInstance().registerRuneSource(this);
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(35,892);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (!this.isConscious()){
            map.removeActor(this);
            map.locationOf(this).addActor(new PileOfBones(this));
        }
        return new DoNothingAction();
    }
}
