package game.actors.enemies.skeletal;

import game.utils.RandomNumberGenerator;

public class SkeletalBandit extends Undead{
    public SkeletalBandit() {
        super("Skeletal Bandit",'b',184);
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(35,892);
    }
}
