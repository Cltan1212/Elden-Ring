package game.actors.enemies.water;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.enemies.Enemy;
import game.behaviours.AttackBehaviour;
import game.behaviours.WanderBehaviour;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

public abstract class Crustracean extends Enemy {

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Crustracean(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_DOG_TYPE_ENEMY);
        this.addCapability(Status.HOSTILE_TO_SKELETAL_TYPE_ENEMY);

        this.behaviours.put(999, new WanderBehaviour());
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        if (otherActor.hasCapability(Status.HOSTILE_TO_WATER_TYPE_ENEMY)){
            this.behaviours.put(3, new AttackBehaviour(otherActor));
        }
        return super.allowableActions(otherActor, direction, map);
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(318,4961);
    }

}
