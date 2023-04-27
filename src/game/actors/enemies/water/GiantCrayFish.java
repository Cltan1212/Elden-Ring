package game.actors.enemies.water;

import game.utils.RandomNumberGenerator;
import game.weapons.GiantCrabSlam;

public class GiantCrayFish extends Crustracean{
    public GiantCrayFish() {
        super("Giant Cray Fish", 'R',4803);
        this.addWeaponToInventory(new GiantCrabSlam());
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(500,2374);
    }
}
