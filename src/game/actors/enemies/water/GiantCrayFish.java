package game.actors.enemies.water;

import game.weapons.GiantCrayFishPincer;

public class GiantCrayFish extends WaterType {

    /**
     * Constructor.
     */
    public GiantCrayFish() {
        super("Giant Cray Fish", 'R', 4803);
        this.addWeaponToInventory(new GiantCrayFishPincer());
    }

    @Override
    public void reset() {

    }
}
