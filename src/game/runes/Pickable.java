package game.runes;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public interface Pickable {
    String pick(Actor actor, GameMap map);
}
