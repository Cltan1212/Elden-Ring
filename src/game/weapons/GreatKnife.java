package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class GreatKnife extends WeaponItem {
    /**
     * Constructor.
     *
     */
    public GreatKnife() {
        super("Great Knife", '/', 75, "", 70);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}
}