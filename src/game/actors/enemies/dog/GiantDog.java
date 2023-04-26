package game.actors.enemies.dog;

import game.utils.RandomNumberGenerator;

public class GiantDog extends Dog {

    public GiantDog() {
        super("Giant Dog",'G',693);
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(313,1808);
    }
}
