package game.actors.enemies.dog;

import game.utils.RandomNumberGenerator;
import game.weapons.GiantDogHead;

public class GiantDog extends DogType {

    public GiantDog() {
        super("Giant Dog",'G',693, 4);
        this.addWeaponToInventory(new GiantDogHead());
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(313,1808);
    }
}
