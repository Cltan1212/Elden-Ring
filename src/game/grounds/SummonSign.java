package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.actorActions.AllyInvaderSpawnAction;
import game.actors.allyInvader.Ally;
import game.actors.allyInvader.Invader;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

public class SummonSign extends Ground {

    public Actor spawnAllyOrInvader;

    // intentionally summon them rather than automatically spawning
    /**
     * Constructor.
     */
    public SummonSign() {
        super('=');
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            // 50% chance of spawning either Ally or Invader
            int randomChance = RandomNumberGenerator.getRandomInt(0, 1);
            if (randomChance == 0) {
                // spawn Ally 50%
                spawnAllyOrInvader = new Ally();
            } else {
                // spawn Invader 50%
                spawnAllyOrInvader = new Invader();
            }
            actions.add(new AllyInvaderSpawnAction(spawnAllyOrInvader));
        }
        return actions;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);  // actor can step on summon sign
    }
}
