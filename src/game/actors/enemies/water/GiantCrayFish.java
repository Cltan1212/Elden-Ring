package game.actors.enemies.water;

import game.utils.RandomNumberGenerator;
import game.weapons.GiantCrabSlam;

public class GiantCrayFish extends WaterType {
    public GiantCrayFish() {
        super("Giant Cray Fish", 'R',4803, 1);
        this.addWeaponToInventory(new GiantCrabSlam());
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(500,2374);
    }
}
