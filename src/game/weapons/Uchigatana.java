package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class Uchigatana extends WeaponItem {
    public Uchigatana() {
        super("Uchigatana", ')', 115, "", 80);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}
}