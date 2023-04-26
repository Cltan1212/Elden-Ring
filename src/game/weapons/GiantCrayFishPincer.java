package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.Status;

public class GiantCrayFishPincer extends WeaponItem {

    public GiantCrayFishPincer() {
        super("Giant CrayFish Pincer", ' ', 527, "", 100);
        this.addCapability(Status.SPECIAL_SKILL);
    }
}
