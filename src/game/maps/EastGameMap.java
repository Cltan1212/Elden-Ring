package game.maps;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.GroundFactory;
import edu.monash.fit2099.engine.positions.Location;

import java.util.List;

public class EastGameMap extends GameMap implements EnemyLocation{
    public EastGameMap(GroundFactory groundFactory, List<String> lines) {
        super(groundFactory, lines);
    }

    @Override
    public Location enemyLocation() {
        return null;
    }
}
