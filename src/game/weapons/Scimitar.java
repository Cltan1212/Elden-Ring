package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.Status;

public class Scimitar extends WeaponItem {

    /**
     * Constructor.
     *
     */
    public Scimitar() {
        super("Scimitar", 's', 118, "", 88);
        this.addCapability(Status.SPECIAL_SKILL);
    }
}
