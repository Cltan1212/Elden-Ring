package game.actors.enemies.skeletal;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.actorActions.DespawnedAction;
import game.actors.enemies.Enemy;
import game.actors.enemies.EnemyType;
import game.actors.enemies.PileOfBones;
import game.behaviours.Behaviour;
import game.utils.RandomNumberGenerator;
import game.utils.Status;
import game.weapons.Grossmesser;

public abstract class Undead extends Enemy {

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Undead(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(EnemyType.SKELETAL);
        this.addCapability(Status.HOSTILE_TO_DOG_TYPE_ENEMY);
        this.addCapability(Status.HOSTILE_TO_WATER_TYPE_ENEMY);
        this.addCapability(Status.SPECIAL_DEATH);
        this.addWeaponToInventory(new Grossmesser());
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
        int randomNum = RandomNumberGenerator.getRandomInt(100);
        // if not following and randomNum generated is less or equal to DESPAWN_CHANCE

        if (!behaviours.containsKey(1)){
            if (randomNum <= DESPAWN_CHANCE){
                return new DespawnedAction();
            }
        }
        else if (randomNum <= DESPAWN_CHANCE && behaviours.get(1).getAction(this, map) != null){
            return new DespawnedAction();
        }

        // add valid behaviour to the list of behaviours
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

}
