package game.actors.enemies.dog;

import game.utils.RandomNumberGenerator;
import game.weapons.GiantDogHead;

public class GiantDog extends Dog {

    public GiantDog() {
        super("Giant Dog",'G',693);
        this.addWeaponToInventory(new GiantDogHead());
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(313,1808);
    }
}
