package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.Status;

public class GreatKnife extends WeaponItem {


    /**
     * Constructor.
     */
    public GreatKnife() {
        // starting weapon of Bandit class
        super("Great Knife", '/', 75, "", 70);
        this.addCapability(Status.SELLING);

        // allow the user to perform quickstep

    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}


}
