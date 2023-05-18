package game.actions.actorActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.allyInvader.Ally;
import game.actors.allyInvader.Invader;
import game.utils.RandomNumberGenerator;
import game.utils.Status;
import java.util.ArrayList;
import java.util.List;

public class AllyInvaderSpawnAction extends Action {

    public AllyInvaderSpawnAction() {
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {

            // spawn at a random location around the 8 exits
            List<Location> emptyLocations = new ArrayList<>();
            for (Exit exit : map.locationOf(actor).getExits()) {
                Location destination = exit.getDestination();
                if (destination.canActorEnter(actor) && !destination.containsAnActor()) {
                    emptyLocations.add(destination);
                }
            }
            if (!emptyLocations.isEmpty()) {
                Location newLocation = emptyLocations.get(RandomNumberGenerator.getRandomInt(emptyLocations.size()));
                int randomChance = RandomNumberGenerator.getRandomInt(0, 1);
                if (randomChance == 0) {
                    // spawn Ally 50%
                    newLocation.addActor(new Ally());
                } else {
                    // spawn Invader 50%
                    newLocation.addActor(new Invader());
                }
            }
        }
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " summons a guest from another realm.";
    }
}
