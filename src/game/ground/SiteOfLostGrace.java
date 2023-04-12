package game.ground;

import edu.monash.fit2099.engine.positions.Ground;
import game.Status;

public class SiteOfLostGrace extends Ground {
    // Allows the player to rest on it
    // when player rest, entire game will be reset

    public SiteOfLostGrace() {
        super('U');
        this.addCapability(Status.RESTING);

    }




}
