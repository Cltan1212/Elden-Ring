package game.utils;

import edu.monash.fit2099.engine.positions.Location;

public class Distance {

    public static int getDistance(Location a, Location b){
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }

}
